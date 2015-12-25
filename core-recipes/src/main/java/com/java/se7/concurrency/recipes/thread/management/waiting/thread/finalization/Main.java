package com.java.se7.concurrency.recipes.thread.management.waiting.thread.finalization;

import java.util.Date;

/**
 * Theory:
 *
 * In some situations, we will have to wait for the finalization of a thread. For example, we may
 * have a program that will begin initializing the resources it needs before proceeding with the
 * rest of the execution. We can run the initialization tasks as threads and wait for its finalization
 * before continuing with the rest of the program.
 *
 * For this purpose, we can use the join() method of the Thread class. When we call this
 * method using a thread object, it suspends the execution of the calling thread until the object
 * called finishes its execution.
 *
 * Main class of the Example. Create and start two initialization tasks
 * and wait for their finish
 *
 */
public class Main {

	/**
	 * Main method of the class. Create and star two initialization tasks
	 * and wait for their finish
	 * @param args
	 */
	public static void main(String[] args) {

		// Creates and starts a DataSourceLoader runnable object
		DataSourcesLoader dsLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dsLoader,"DataSourceThread");
		thread1.start();

		// Creates and starts a NetworkConnectionsLoader runnable object
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");
		thread2.start();

		// Wait for the finalization of the two threads
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Waits a message
		System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
	}
}
