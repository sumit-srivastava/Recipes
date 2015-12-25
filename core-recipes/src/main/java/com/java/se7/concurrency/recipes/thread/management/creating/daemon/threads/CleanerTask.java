package com.java.se7.concurrency.recipes.thread.management.creating.daemon.threads;

import java.util.Date;
import java.util.Deque;

/**
 * Theory:
 *
 * Java has a special kind of thread called daemon thread. These kind of threads have very low
 * priority and normally only executes when no other thread of the same program is running.
 * When daemon threads are the only threads running in a program, the JVM ends the program
 * finishing these threads.
 *
 * With these characteristics, the daemon threads are normally used as service providers for
 * normal(also called user) threads running in the same program. They usually have an infinite loop
 * that waits for the service request or performs the tasks of the thread. They can't do
 * important jobs because we don't know when they are going to have CPU time and they can finish
 * any time if there aren't any other threads running. A typical example of these kind of threads
 * is the Java garbage collector.
 *
 * Class that review the Event data structure and delete
 * the events older than ten seconds
 *
 */
public class CleanerTask extends Thread {

	/**
	 * Data structure that stores events
	 */
	private Deque<Event> deque;

	/**
	 * Constructor of the class
	 * @param deque data structure that stores events
	 */
	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		// Establish that this is a Daemon Thread
		setDaemon(true);
	}


	/**
	 * Main method of the class
	 */
	@Override
	public void run() {
		while (true) {
			Date date = new Date();
			clean(date);
		}
	}

	/**
	 * Method that review the Events data structure and delete
	 * the events older than ten seconds
	 * @param date
	 */
	private void clean(Date date) {
		long difference;
		boolean delete;
		
		if (deque.size()==0) {
			return;
		}
		
		delete=false;
		do {
			Event e = deque.getLast();
			difference = date.getTime() - e.getDate().getTime();
			if (difference > 10000) {
				System.out.printf("Cleaner: %s\n",e.getEvent());
				deque.removeLast();
				delete=true;
			}	
		} while (difference > 10000);
		if (delete){
			System.out.printf("Cleaner: Size of the queue: %d\n",deque.size());
		}
	}
}
