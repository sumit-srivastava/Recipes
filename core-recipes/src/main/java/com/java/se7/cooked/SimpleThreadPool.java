package com.java.se7.cooked;

import java.util.LinkedList;

public class SimpleThreadPool {
	private WorkerThread[] threads;
	private LinkedList<Runnable> taskQueue;

	public SimpleThreadPool(int threadNumber) {
		taskQueue = new LinkedList<Runnable>();
		threads = new WorkerThread[threadNumber];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new WorkerThread();
			threads[i].start();
		}
	}

	public void enqueue(Runnable r) {
		synchronized(taskQueue) {
			taskQueue.addLast(r);
			taskQueue.notifyAll();
		}
	}

	private class WorkerThread extends Thread {
		@Override
		public void run() {
			Runnable r;
			while(true) {
				synchronized(taskQueue) {
					while(taskQueue.isEmpty()) {
						try {
							taskQueue.wait();
						} catch(InterruptedException ie) {
							ie.printStackTrace();
						}
					}
					r = (Runnable)taskQueue.removeFirst();
				}
				try {
					r.run();
				} catch(Exception ie) {
					ie.printStackTrace();
				}

			}
		}
	}
}
