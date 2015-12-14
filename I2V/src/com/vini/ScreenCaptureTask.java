package com.vini;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class ScreenCaptureTask  extends TimerTask{
	
	public static String TEMP_PATH = System.getProperty("java.io.tmpdir");
	public static String IMAGE_DIR_NAME = "captured_screenshots";
	
	public ScreenCaptureTask(boolean resume) {
		if(!resume){
			File imageDir = new File(TEMP_PATH + File.separator + IMAGE_DIR_NAME);
			if(!imageDir.exists()){
				imageDir.mkdir();
			}else{
				File[] existingFiles = imageDir.listFiles();
				for(File file : existingFiles){
					file.delete();
				}
			}
		}
	}
		

	@Override
	public void run() {
		try {
			captureScreen(TEMP_PATH + File.separator + IMAGE_DIR_NAME, "s" + (System.currentTimeMillis()), "JPG");
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Method to capture Screenshot in JPG format
	 * @param path
	 * @param fileName
	 * @param format
	 * @return JPG Screenshot file
	 * @throws AWTException 
	 * @throws IOException 
	 */
	public static File captureScreen(String path, String fileName, String format) throws AWTException, IOException {
		File screenshot = new File(path + File.separator + fileName + "." + format.toString().toLowerCase());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screen = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screen);
		ImageIO.write(image, format.toString(), screenshot);
		return screenshot;
	}
	
	/**
	 * Method to delete the temp files
	 */
	public static void cleanupTempFiles(){
		File imageDir = new File(TEMP_PATH + File.separator + IMAGE_DIR_NAME);
		for(File file : imageDir.listFiles()){
			file.delete();
		}
	}

}
