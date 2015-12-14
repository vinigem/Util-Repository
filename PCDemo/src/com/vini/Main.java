package com.vini;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static List<Record> records = new ArrayList<Record>();

	public static void main(String[] args) {
		for(int index = 1; index <= 1000; index++){
			records.add(new Record(index, "Record "+index));
		}

		BlockingQueue<Record> recordQueue = new LinkedBlockingQueue<Record>();
		int size=50;
		Thread prodThread = new Thread(new Producer(recordQueue, size), "Producer");
		Thread consThread1 = new Thread(new Consumer(recordQueue), "Consumer1");
		Thread consThread2 = new Thread(new Consumer(recordQueue), "Consumer2");
		Thread consThread3 = new Thread(new Consumer(recordQueue), "Consumer3");
		prodThread.start();
		consThread1.start();
		consThread2.start();
		consThread3.start();
	}

	public static int getMaxSize(){
		return records.size();
	}

}
