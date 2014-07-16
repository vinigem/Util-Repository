package com.vini;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
	
	private BlockingQueue<Record> recordQueue;
	private int queueSize;
	
	public Producer(BlockingQueue<Record> recordQueue, int queueSize) {
		this.recordQueue =recordQueue;
		this.queueSize = queueSize;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for(int index = 0; index < Main.getMaxSize(); index++){
			try{
				while (recordQueue.size() == queueSize) {
					synchronized (recordQueue) {
						System.out.println("Queue is full " + Thread.currentThread().getName()
								+ " is waiting , size: " + recordQueue.size());

						recordQueue.wait();
					}
				}

				//producing element and notify consumers
				synchronized (recordQueue) {
					recordQueue.add(Main.records.get(index));
					recordQueue.notifyAll();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time taken :"+ (endTime-startTime));
	}
}
