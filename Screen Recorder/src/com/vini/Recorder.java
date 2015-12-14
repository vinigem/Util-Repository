package com.vini;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.Vector;

import javax.media.Buffer;
import javax.media.ConfigureCompleteEvent;
import javax.media.Controller;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.DataSink;
import javax.media.EndOfMediaEvent;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.PrefetchCompleteEvent;
import javax.media.Processor;
import javax.media.RealizeCompleteEvent;
import javax.media.ResourceUnavailableEvent;
import javax.media.Time;
import javax.media.control.TrackControl;
import javax.media.datasink.DataSinkErrorEvent;
import javax.media.datasink.DataSinkEvent;
import javax.media.datasink.DataSinkListener;
import javax.media.datasink.EndOfStreamEvent;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;
import javax.media.protocol.FileTypeDescriptor;
import javax.media.protocol.PullBufferDataSource;
import javax.media.protocol.PullBufferStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class Recorder extends JFrame implements ControllerListener, DataSinkListener{

	private static final long serialVersionUID = 1L;

	private static final int SIZE_25 = 25;
	private JButton record;
	private JButton stop;
	private JButton pause;
	private JButton resume;
	private Timer timer;
	private final ImageIcon recordIcon = new ImageIcon(new ImageIcon(getClass().getResource("/resources/record.png")).getImage().getScaledInstance(SIZE_25, SIZE_25, Image.SCALE_SMOOTH));
	private final ImageIcon stopIcon = new ImageIcon(new ImageIcon(getClass().getResource("/resources/stop.png")).getImage().getScaledInstance(SIZE_25, SIZE_25, Image.SCALE_SMOOTH));
	private final ImageIcon pauseIcon = new ImageIcon(new ImageIcon(getClass().getResource("/resources/pause.png")).getImage().getScaledInstance(SIZE_25, SIZE_25, Image.SCALE_SMOOTH));
	private final ImageIcon resumeIcon = new ImageIcon(new ImageIcon(getClass().getResource("/resources/play.png")).getImage().getScaledInstance(SIZE_25, SIZE_25, Image.SCALE_SMOOTH));
	
	public Recorder() {
		setSize(80, 55);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		addButtons();
		addListeners();
		setTitle("Recorder");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	/**
	 * Add Record and Stop buttons
	 */
	private void addButtons() {
		record = new JButton(recordIcon); 
		record.setBounds(5, 0, SIZE_25, SIZE_25);
		record.setBorder(BorderFactory.createEmptyBorder());
		record.setToolTipText("Record");
		add(record); 
		
		pause = new JButton(pauseIcon);  
		pause.setBounds(35, 0, SIZE_25, SIZE_25);
		pause.setBorder(BorderFactory.createEmptyBorder());
		pause.setEnabled(false);
		pause.setToolTipText("Pause");
		add(pause);
		
		resume = new JButton(resumeIcon);  
		resume.setBounds(65, 0, SIZE_25, SIZE_25);
		resume.setBorder(BorderFactory.createEmptyBorder());
		resume.setEnabled(false);
		resume.setToolTipText("Resume");
		add(resume); 

		stop = new JButton(stopIcon);  
		stop.setBounds(95, 0, SIZE_25, SIZE_25);
		stop.setBorder(BorderFactory.createEmptyBorder());
		stop.setEnabled(false);
		stop.setToolTipText("Stop");
		add(stop);  

	}

	/**
	 * Add mouse click listeners to the buttons
	 */
	private void addListeners() {
		record.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				timer = new Timer();
				timer.schedule(new ScreenCaptureTask(false), 0, 40);
				stop.setEnabled(true);
				pause.setEnabled(true);
				record.setEnabled(false);
				Recorder.this.revalidate(); // For Java 1.7 or above
				Recorder.this.getContentPane().validate(); // For Java 1.6 or below
				Recorder.this.repaint();
			}
		});
		
		pause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				timer.cancel();
				resume.setEnabled(true);
				pause.setEnabled(false);
				Recorder.this.revalidate(); // For Java 1.7 or above
				Recorder.this.getContentPane().validate(); // For Java 1.6 or below
				Recorder.this.repaint();
			}
		});
		
		resume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				timer = new Timer();
				timer.schedule(new ScreenCaptureTask(true), 0, 40);
				resume.setEnabled(false);
				pause.setEnabled(true);
				Recorder.this.revalidate(); // For Java 1.7 or above
				Recorder.this.getContentPane().validate(); // For Java 1.6 or below
				Recorder.this.repaint();
			}
		});

		stop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				timer.cancel();

				JFileChooser saveFile = new JFileChooser();
				saveFile.setDialogTitle("Specify a file name to save");   

				int userSelection = saveFile.showSaveDialog(Recorder.this);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					URL fileToSave = null;
					try {
						fileToSave = new URL("file:/" + saveFile.getSelectedFile().getAbsolutePath() + ".mp4");
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
					try {
						createVideo(fileToSave);
						ScreenCaptureTask.cleanupTempFiles();
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
				record.setEnabled(true);
				stop.setEnabled(false);
				pause.setEnabled(false);
				resume.setEnabled(false);
				Recorder.this.revalidate(); // For Java 1.7 or above
				Recorder.this.getContentPane().validate(); // For Java 1.6 or below
				Recorder.this.repaint();
			}
		});

	}


	/**
	 * Method to create video file
	 * @param fileToSave
	 * @throws MalformedURLException
	 */
	protected void createVideo(URL fileToSave) throws MalformedURLException {
		Vector<String> imgLst = new Vector<String>();

		File[] files = new File(ScreenCaptureTask.TEMP_PATH + File.separator + ScreenCaptureTask.IMAGE_DIR_NAME).listFiles();
		for(File file: files){
			imgLst.add(file.getAbsolutePath());
		}

		MediaLocator mediaLocator = new MediaLocator(fileToSave);
		createVideoFromImages(800, 600, 16, imgLst, mediaLocator);
	}

	Object waitSync = new Object();
	boolean stateTransitionOK = true;
	Object waitFileSync = new Object();
	boolean fileDone = false;
	boolean fileSuccess = true;

	/**
	 * Method to create video files from images
	 * @param width
	 * @param height
	 * @param frameRate
	 * @param imageFiles
	 * @param mediaLocator
	 */
	protected void createVideoFromImages(int width, int height, int frameRate, Vector<String> imageFiles, MediaLocator mediaLocator){
		ImageDataSource ids = new ImageDataSource(width, height, frameRate,	imageFiles);

		Processor processor;

		try {
			processor = Manager.createProcessor(ids);
			processor.addControllerListener(this);
			processor.addControllerListener(this);

			// Put the Processor into configured state so we can set some processing options on the processor.
			processor.configure();
			if (!waitForState(processor, Processor.Configured)) {
				System.err.println("Failed to configure the processor.");
				return;
			}

			// Set the output content descriptor to QuickTime.
			processor.setContentDescriptor(new ContentDescriptor(FileTypeDescriptor.QUICKTIME));

			// Query for the processor for supported formats. Then set it on the processor.
			TrackControl tcs[] = processor.getTrackControls();
			Format f[] = tcs[0].getSupportedFormats();

			if (f == null || f.length <= 0) {
				System.err.println("The mux does not support the input format: " + tcs[0].getFormat());
				return;
			}

			tcs[0].setFormat(f[0]);

			// We are done with programming the processor. Let's just realize it.
			processor.realize();
			if (!waitForState(processor, Controller.Realized)) {
				System.err.println("Failed to realize the processor.");
				return;
			}

			// Now, we'll need to create a DataSink.
			DataSink dsink;
			if ((dsink = createDataSink(processor, mediaLocator)) == null) {
				System.err.println("Failed to create a DataSink for the given output MediaLocator: "+ mediaLocator);
				return;
			}

			dsink.addDataSinkListener(this);
			fileDone = false;

			System.out.println("Generating the video : " + mediaLocator.getURL().toString());

			// OK, we can now start the actual transcoding.
			try {
				processor.start();
				dsink.start();
			} catch (IOException e) {
				System.err.println("IO error during processing");
				return;
			}

			// Wait for EndOfStream event.
			waitForFileDone();

			// Cleanup processor.
			dsink.close();
			processor.removeControllerListener(this);

			System.out.println("Video creation completed!!!!!");
			return;
		} catch (Exception e) {
			System.err.println("Yikes!  Cannot create a processor from the data source.");
			return;
		}



	}

	/**
	 * Create the DataSink.
	 */
	DataSink createDataSink(Processor p, MediaLocator outML) {

		DataSource ds;

		if ((ds = p.getDataOutput()) == null) {
			System.err.println("Something is really wrong: the processor does not have an output DataSource");
			return null;
		}

		DataSink dsink;

		try {
			dsink = Manager.createDataSink(ds, outML);
			dsink.open();
		} catch (Exception e) {
			System.err.println("Cannot create the DataSink: " + e);
			return null;
		}

		return dsink;
	}


	/**
	 * Block until the processor has transitioned to the given state. Return
	 * false if the transition failed.
	 */
	boolean waitForState(Processor p, int state) {
		synchronized (waitSync) {
			try {
				while (p.getState() < state && stateTransitionOK)
					waitSync.wait();
			} catch (Exception e) {
			}
		}
		return stateTransitionOK;
	}

	/**
	 * Controller Listener.
	 */
	public void controllerUpdate(ControllerEvent evt) {

		if (evt instanceof ConfigureCompleteEvent
				|| evt instanceof RealizeCompleteEvent
				|| evt instanceof PrefetchCompleteEvent) {
			synchronized (waitSync) {
				stateTransitionOK = true;
				waitSync.notifyAll();
			}
		} else if (evt instanceof ResourceUnavailableEvent) {
			synchronized (waitSync) {
				stateTransitionOK = false;
				waitSync.notifyAll();
			}
		} else if (evt instanceof EndOfMediaEvent) {
			evt.getSourceController().stop();
			evt.getSourceController().close();
		}
	}



	/**
	 * Block until file writing is done.
	 */
	boolean waitForFileDone() {
		synchronized (waitFileSync) {
			try {
				while (!fileDone)
					waitFileSync.wait();
			} catch (Exception e) {
			}
		}
		return fileSuccess;
	}

	/**
	 * Event handler for the file writer.
	 */
	public void dataSinkUpdate(DataSinkEvent evt) {

		if (evt instanceof EndOfStreamEvent) {
			synchronized (waitFileSync) {
				fileDone = true;
				waitFileSync.notifyAll();
			}
		} else if (evt instanceof DataSinkErrorEvent) {
			synchronized (waitFileSync) {
				fileDone = true;
				fileSuccess = false;
				waitFileSync.notifyAll();
			}
		}
	}

	/**
	 * A DataSource to read from a list of JPEG image files and turn that into a
	 * stream of JMF buffers. The DataSource is not seekable or positionable.
	 */
	class ImageDataSource extends PullBufferDataSource {

		ImageSourceStream streams[];

		ImageDataSource(int width, int height, int frameRate, Vector<String> images) {
			streams = new ImageSourceStream[1];
			streams[0] = new ImageSourceStream(width, height, frameRate, images);
		}

		public void setLocator(MediaLocator source) {
		}

		public MediaLocator getLocator() {
			return null;
		}

		/**
		 * Content type is of RAW since we are sending buffers of video frames
		 * without a container format.
		 */
		public String getContentType() {
			return ContentDescriptor.RAW;
		}

		public void connect() {
		}

		public void disconnect() {
		}

		public void start() {
		}

		public void stop() {
		}

		/**
		 * Return the ImageSourceStreams.
		 */
		public PullBufferStream[] getStreams() {
			return streams;
		}

		/**
		 * We could have derived the duration from the number of frames and
		 * frame rate. But for the purpose of this program, it's not necessary.
		 */
		public Time getDuration() {
			return DURATION_UNKNOWN;
		}

		public Object[] getControls() {
			return new Object[0];
		}

		public Object getControl(String type) {
			return null;
		}
	}

	/**
	 * The source stream to go along with ImageDataSource.
	 */
	class ImageSourceStream implements PullBufferStream {

		Vector<String> images;
		int width, height;
		VideoFormat format;

		int nextImage = 0; // index of the next image to be read.
		boolean ended = false;

		public ImageSourceStream(int width, int height, int frameRate,
				Vector<String> images) {
			this.width = width;
			this.height = height;
			this.images = images;

			format = new VideoFormat(VideoFormat.JPEG, new Dimension(width,
					height), Format.NOT_SPECIFIED, Format.byteArray, (float) frameRate);
		}

		/**
		 * We should never need to block assuming data are read from files.
		 */
		public boolean willReadBlock() {
			return false;
		}

		/**
		 * This is called from the Processor to read a frame worth of video
		 * data.
		 */
		public void read(Buffer buf) throws IOException {

			// Check if we've finished all the frames.
			if (nextImage >= images.size()) {
				// We are done. Set EndOfMedia.
				//System.err.println("Done reading all images.");
				buf.setEOM(true);
				buf.setOffset(0);
				buf.setLength(0);
				ended = true;
				return;
			}

			String imageFile = (String) images.elementAt(nextImage);
			nextImage++;

			// Open a random access file for the next image.
			RandomAccessFile raFile;
			raFile = new RandomAccessFile(imageFile, "r");

			byte data[] = null;

			// Check the input buffer type & size.

			if (buf.getData() instanceof byte[])
				data = (byte[]) buf.getData();

			// Check to see the given buffer is big enough for the frame.
			if (data == null || data.length < raFile.length()) {
				data = new byte[(int) raFile.length()];
				buf.setData(data);
			}

			// Read the entire JPEG image from the file.
			raFile.readFully(data, 0, (int) raFile.length());

			buf.setOffset(0);
			buf.setLength((int) raFile.length());
			buf.setFormat(format);
			buf.setFlags(buf.getFlags() | Buffer.FLAG_KEY_FRAME);

			// Close the random access file.
			raFile.close();
		}

		/**
		 * Return the format of each video frame. That will be JPEG.
		 */
		public Format getFormat() {
			return format;
		}

		public ContentDescriptor getContentDescriptor() {
			return new ContentDescriptor(ContentDescriptor.RAW);
		}

		public long getContentLength() {
			return 0;
		}

		public boolean endOfStream() {
			return ended;
		}

		public Object[] getControls() {
			return new Object[0];
		}

		public Object getControl(String type) {
			return null;
		}
	}

}
