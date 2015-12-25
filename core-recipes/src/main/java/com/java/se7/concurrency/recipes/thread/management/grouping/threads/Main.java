package com.java.se7.concurrency.recipes.thread.management.grouping.threads;

import java.util.concurrent.TimeUnit;

/**
 * Theory:
 *
 * An interesting functionality offered by the concurrency API of Java is the ability to group the
 * threads. This allows us to treat the threads of a group as a single unit and provides access to
 * the Thread objects that belong to a group to do an operation with them. For example, you have
 * some threads doing the same task and you want to control them, irrespective of how many
 * threads are still running, the status of each one will interrupt all of them with a single call.
 *
 * Java provides the ThreadGroup class to work with groups of threads. A ThreadGroup object
 * can be formed by Thread objects and by another ThreadGroup object, generating a tree
 * structure of threads.
 *
 *
 *
 */

public class Main {

	/**
	 * Main class of the example
	 * @param args
	 */
	public static void main(String[] args) {

		// Create a ThreadGroup
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result=new Result();

		// Create a SeachTask and 10 Thread objects with this Runnable
		SearchTask searchTask=new SearchTask(result);
		for (int i=0; i<5; i++) {
			Thread thread=new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Write information about the ThreadGroup to the console
		System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		threadGroup.list();

		// Write information about the status of the Thread objects to the console
		Thread[] threads=new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i=0; i<threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
		}

		// Wait for the finalization of the Threadds
		waitFinish(threadGroup);
		
		// Interrupt all the Thread objects assigned to the ThreadGroup
		threadGroup.interrupt();
	}

	/**
	 * Method that waits for the finalization of one of the ten Thread objects
	 * assigned to the ThreadGroup
	 * @param threadGroup
	 */
	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount()>9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
