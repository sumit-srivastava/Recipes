package com.java.se7.concurrency.recipes.thread.management.processing.uncontrolled.exceptions.in.thread;

/**
 * Runnable class than throws and Exception
 *
 */
public class Task implements Runnable {


	/**
	 * Main method of the class
	 */
	@Override
	public void run() {
		// The next instruction always throws and exception
		int numero=Integer.parseInt("TTT");
	}

}
