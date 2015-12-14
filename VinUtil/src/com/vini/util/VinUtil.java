package com.vini.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.imageio.ImageIO;

public class VinUtil {

	public enum StorageUnit { KB, MB, GB, TB };
	public enum ImageFormat { PNG, JPG, BMP};

	/**
	 * Method to convert size from bytes to GB
	 * @param bytes
	 * @param unit
	 * @return converted size
	 */
	public static double convertBytes(long bytes, StorageUnit unit) {
		double kiloBytes = ((double)bytes / 1024);
		if(unit == StorageUnit.KB){
			return kiloBytes;
		}else{
			double megaBytes = (kiloBytes / 1024);
			if(unit == StorageUnit.MB){
				return megaBytes;
			}else{
				double gigaBytes = (megaBytes / 1024);
				if(unit == StorageUnit.GB){
					return gigaBytes;
				}else{
					double teraBytes = (gigaBytes / 1024);
					if(unit == StorageUnit.TB){
						return teraBytes;
					}
				}
			}
		}
		return 0.0;
	}

	/**
	 * Method to format the size in decimal
	 * @param gigabytes
	 * @return formatted size
	 */
	public static double format(double gigabytes) {
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setDecimalSeparator('.');
		return Double.valueOf(new DecimalFormat("#.##", symbols).format(gigabytes));
	}

	/**
	 * Method to Read the contents by connecting to a http URL
	 * @param httpUrl
	 * @return contents of the URL
	 * @throws IOException 
	 */
	public static String readHttpUrl(String httpUrl) throws IOException{
		URLConnection urlConnection = null;
		InputStream input = null;
		StringBuffer value = new StringBuffer();
		URL url = new URL(httpUrl);
		urlConnection = url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setUseCaches(false);
		urlConnection.connect();
		input = urlConnection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line = null;
		while((line = reader.readLine()) != null){
			value.append(line);
		}
		reader.close();
		input.close();
		return value.toString();
	}

	/**
	 * Method to Read all the files of a directory
	 * @param directory root directory to be read
	 * @return List of Files in the directory
	 */
	public static List<File> getAllFolders(String directory) {
		List<File> foldersList = new ArrayList<File>(); 
		File pathName = new File(directory);  
		File[] fileNames = pathName.listFiles();  // lists all files in the directory
		if(null != fileNames){
			for(File file: pathName.listFiles()){
				foldersList.add(file);
			}
		}
		return foldersList;
	}

	/**
	 * Method to get the name of the user, using NET command
	 * @param id
	 * @return user name
	 * @throws IOException 
	 */
	public static String getUserName(String id) throws IOException{
		Process p = Runtime.getRuntime().exec("NET USER "+id+" /DOMAIN");
		InputStreamReader reader = new InputStreamReader(p.getInputStream());
		BufferedReader input = new BufferedReader(reader);
		String line = null;
		while ((line = input.readLine()) != null) {
			if(null != line && line.contains("Full Name")){
				return line.substring(10).trim();
			}
		}
		reader.close();
		input.close();
		return "";
	}

	/**
	 * Method to get the file size of a folder i.e. Sum of all the contents of that folder
	 * @param file or folder
	 * @return size of file or folder in bytes
	 */
	public static long getFileSize(File folder) {
		long foldersize = 0;
		if(folder.isDirectory() && null != folder.listFiles()){
			for(File file : folder.listFiles()){
				if (file.isFile()){
					foldersize += file.length();
				}else{
					foldersize += getFileSize(file);
				}
			}
		}
		return foldersize;
	}

	/**
	 * Method to delete the contents of a folder
	 * @param folder
	 */
	public static void deleteFolderContent(File tempFolder) {
		String[] tempFiles = tempFolder.list();
		for(int index=0; index < tempFiles.length; index++){
			File tempFile = new File(tempFolder.getPath(), tempFiles[index]); // getPath converts abstract path to path in String,
			if(tempFile.isDirectory()){
				deleteFolderContent(tempFile);
			}else{
				tempFile.delete();
			}
		}
	}

	/**
	 * Method to get OS Information
	 * @return OS Information
	 */
	public static String getOSInfo(){
		StringBuffer info = new StringBuffer();
		Formatter formatter = new Formatter();
		formatter.format("%s %s", "OS Name", System.getProperty("os.name")+"\n");
		formatter.format("%s %s", "OS Version", System.getProperty("os.version")+"\n");
		formatter.format("%s %s", "OS Architecture", System.getProperty("os.arch")+"\n");
		formatter.format("%s %s", "Java Version", System.getProperty("java.version")+"\n");
		formatter.format("%s %s", "Java Vendor", System.getProperty("java.vendor")+"\n");
		info.append(formatter);
		return info.toString();
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
	public static File captureScreen(String path, String fileName, ImageFormat format) throws AWTException, IOException {
		File screenshot = new File(path+"/"+fileName+"."+format.toString().toLowerCase());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screen = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screen);
		ImageIO.write(image, format.toString(), screenshot);
		return screenshot;
	}



}
