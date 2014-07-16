package com.vini.monitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vinit Kumar
 * This thread copies the request and response from the client to server and and vice versa. 
 */
class CopyThread extends Thread {

	private static Logger LOGGER = LoggerFactory.getLogger("com.vini.monitor.CopyThread");


	InputStream in;
	OutputStream out;
	int counter;

	public CopyThread(String name, int counter, InputStream in, OutputStream out) {
		super(name);
		this.in = in;
		this.out = out;
		this.counter = counter;
	}

	public void run() {
		byte[] b = new byte[128];
		StringBuffer buffer = new StringBuffer();
		try {
			while (true) {
				int m = in.read(b, 0, b.length);
				if (m == -1) {
					break;
				}
				String str = new String(b,0,m);
				if(str.contains("Host: "+Monitor.props.getProperty("localHost"))){
					str = str.replace("Host: "+Monitor.props.getProperty("localHost"), "Host: "+Monitor.props.getProperty("serverHost"));
					b = str.getBytes();
				}
				out.write(b, 0, m);
				buffer.append(new String(b, Charset.forName("UTF-8")), 0 , m);
			}
		}catch (IOException ex) {
		}

		if("Request".equals(getName())){
			LOGGER.info("Request[{}]:\n"+buffer.toString(), counter);
		}else if("Response".equals(getName())){
			LOGGER.info("Response[{}]:\n"+buffer.toString(), counter);
		}


	}

}