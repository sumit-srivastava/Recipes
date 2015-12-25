package com.java.se7.concurrency.recipes.thread.management.using.local.thread.variables;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Theory:
 *
 * One of the most critical aspects of a concurrent application is shared data. This has
 * special importance in those objects that extend the Thread class or implement the Runnable interface.
 *
 * If you create an object of a class that implements the Runnable interface and then start
 * various Thread objects using the same Runnable object, all the threads share the same
 * attributes. This means that, if you change an attribute in a thread, all the threads will be affected by this change.
 *
 * Sometimes, you will be interested in having an attribute that won't be shared between all the
 * threads that run the same object. The Java Concurrency API provides a clean mechanism
 * called thread-local variables with a very good performance.
 *
 * Thread-local variables store a value of an attribute for each Thread that uses one of these
 * variables. You can read the value using the get() method and change the value using the
 * set() method. The first time you access the value of a thread-local variable, if has no value for
 * the Thread object that it is calling, the thread-local variable calls the initialValue() method to
 * assign a value for for that Thread and returns the initial value.
 *
 * The thread-local class also provides the remove() method that deletes the value stored in
 * the thread-local variable for the thread that it's calling.
 * The Java Concurrency API includes the InheritableThreadLocal class that provides
 * inheritance of values for threads created from a thread. If a thread A has a value in a thread-
 * local variable and it creates another thread B, the thread B will have the same value as the
 * thread A in the thread-local variable. You can override the childValue() method that is
 * called to initialize the value of the child thread in the thread-local variable. It receives the
 * value of the parent thread in the thread-local variable as a parameter.
 *
 *
 * Class that shows the usage of ThreadLocal variables to share
 * data between Thread objects
 *
 */
public class SafeTask implements Runnable {

	/**
	 * ThreadLocal shared between the Thread objects
	 */
	private static ThreadLocal<Date> startDate= new ThreadLocal<Date>() {
		protected Date initialValue(){
			return new Date();
		}
	};
	

	/**
	 * Main method of the class
	 */
	@Override
	public void run() {
		// Writes the start date
		System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Writes the start date
		System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
	}

}
