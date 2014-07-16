package com.vini;

import com.vini.util.VinUtil;
import com.vini.util.VinUtil.ImageFormat;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(VinUtil.ImageFormat.JPG.toString());
		try {
			VinUtil.captureScreen("C:\\Users\\719731\\Desktop", "screen", ImageFormat.PNG);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
