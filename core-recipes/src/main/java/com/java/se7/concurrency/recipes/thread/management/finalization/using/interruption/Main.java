package com.java.se7.concurrency.recipes.thread.management.finalization.using.interruption;

import java.util.concurrent.TimeUnit;

/**
 * Theory:
 *
 * The Thread class has an attribute that stores a boolean value indicating whether the
 * thread has been interrupted or not. When you call the interrupt() method of a thread,
 * you set that attribute to true. The isInterrupted() method only returns the value of
 * that attribute.
 *
 * Note: Thread can ignore its interruption, but this is not the expected behaviour.
 *
 * Best use case: The mechanism shown can be used if the thread that can be interrupted is simple.
 *
 * Alternate approach: The Thread class has another method to check whether Thread has been interrupted or not.
 * It's the static method, interrupted(), that checks whether the current executing thread
 * has been interrupted or not.
 */

/**
 *  Main class of the sample. Launch the PrimeGenerator, waits 
 *  five seconds and interrupts the Thread
 */
public class Main {

	/**
	 * Main method of the sample. Launch the PrimeGenerator, waits
	 * five seconds and interrupts the Thread
	 * @param args
	 */
	public static void main(String[] args) {

		// Launch the prime numbers generator
		Thread task=new PrimeGenerator();
		task.start();
		
		// Wait 5 seconds
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Interrupt the prime number generator
		task.interrupt();
	}

}


