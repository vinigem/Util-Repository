package com.vini;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	private BlockingQueue<Record> recordQueue;
	
	public Consumer(BlockingQueue<Record> recordQueue) {
		this.recordQueue =recordQueue;
	}
	
	@Override
	public void run() {
		  while (!recordQueue.isEmpty()) {
	            try {
	                System.out.println(Thread.currentThread().getName()+": Consumed: " + consume());
	                Thread.sleep(50);
	            } catch (InterruptedException ex) {
	               ex.printStackTrace();
	            }

	        }
		
	}

	
	private Record consume() throws InterruptedException {
            	synchronized (recordQueue) {
            	recordQueue.notifyAll();
            	return recordQueue.remove();
            	}
    }

}
