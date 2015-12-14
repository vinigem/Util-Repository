package com.vini.monitor;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vinit Kumar
 * This class creates a ServerSocket at a local port 
 * and monitors all the request and response and logs it.
 */
public class Monitor{

	private static Logger LOGGER = LoggerFactory.getLogger("com.vini.monitor.Monitor");
	private static ServerSocket serverSocket;
	public static Properties props;
	private static String path = "./monitor.properties";
	private static int COUNTER = 1;

	
	public static void main (String args[]) {
		loadProperties();
		try {
			serverSocket = new ServerSocket(Integer.valueOf(props.getProperty("localPort")), 0, InetAddress.getByName(props.getProperty("localHost")));
			LOGGER.info("Monitor is listening to port '"+props.getProperty("localPort")+"'.");

			while(true){
				LOGGER.info("Server is running...");
				Socket client = serverSocket.accept();
				
				LOGGER.info("Client at: " + client.getRemoteSocketAddress());
				Socket redirectSocket = new Socket(InetAddress.getByName(props.getProperty("serverHost")), Integer.valueOf(props.getProperty("serverPort")));
				LOGGER.info("Connection created."+redirectSocket);
				
				CopyThread toServer = new CopyThread("Request", COUNTER, client.getInputStream(), redirectSocket.getOutputStream());
				CopyThread fromServer = new CopyThread("Response", COUNTER, redirectSocket.getInputStream(), client.getOutputStream());
				
				toServer.start();
				fromServer.start();
				
				COUNTER ++;
			}
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage());
			System.exit(1);
		}
	}


	private static void loadProperties() {
		try {
			props = new Properties();
			props.load(new FileInputStream(path));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			LOGGER.info("Properties file failed to load. Using default values.");
			props = new Properties();
			props.setProperty("localPort", "9190");
			props.setProperty("serverPort", "9090");
			props.setProperty("localHost", "localhost");
			props.setProperty("serverHost", "localhost");
		}
	}


}