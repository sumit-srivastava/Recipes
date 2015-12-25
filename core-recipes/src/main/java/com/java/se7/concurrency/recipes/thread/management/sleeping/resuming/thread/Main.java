package com.java.se7.concurrency.recipes.thread.management.sleeping.resuming.thread;

import java.util.concurrent.TimeUnit;

/**
 * Theory:
 *
 * When you call the sleep() method, Thread leaves the CPU and stops its execution for a
 * period of time. During this time, it's not consuming CPU time, so the CPU can be executing
 * other tasks.
 *
 * Note: When Thread is sleeping and is interrupted, the method throws an InterruptedException
 * exception immediately and doesn't wait until the sleeping time finishes.
 *
 * Main class of the Example. Creates a FileClock runnable object
 * and a Thread to run it. Starts the Thread, waits five seconds
 * and interrupts it. 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creates a FileClock runnable object and a Thread
		// to run it
		FileClock clock=new FileClock();
		Thread thread=new Thread(clock);
		
		// Starts the Thread
		thread.start();
		try {
			// Waits five seconds
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		// Interrupts the Thread
		thread.interrupt();
	}
}
