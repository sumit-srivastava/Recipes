package com.java.se7.concurrency.recipes.thread.management.processing.uncontrolled.exceptions.in.thread;

/**
 * Theory:
 *
 * There are two kinds of exceptions in Java:
 *  --> Checked exceptions: These exceptions must be specified in the throws clause of a method or caught inside them.
 *          For example, IOException or ClassNotFoundException
 *  --> Unchecked exceptions: These exceptions don't have to be specified or caught.
 *          For example, NumberFormatException
 *
 * When a checked exception is thrown inside the run() method of a Thread object, we have
 * to catch and treat them, because the run() method doesn't accept a throws clause. When
 * an unchecked exception is thrown inside the run() method of a Thread object, the default
 * behaviour is to write the stack trace in the console and exit the program.
 *
 * Fortunately, Java provides us with a mechanism to catch and treat the unchecked exceptions
 * thrown in a Thread object to avoid the program ending.
 *
 * When an uncaught exception is thrown in Thread, the JVM looks for three possible handlers for this exception.
 * First, it looks for the uncaught exception handler of the Thread objects as we learned in this recipe.
 * If this handler doesn't exist, then the JVM looks for the uncaught exception handler for ThreadGroup of the Thread objects.
 * If this method doesn't exist, the JVM looks for the default uncaught exception handler. It's the static method
 * setDefaultUncaughtExceptionHandler() that establishes an exception handler for all the Thread objects in the application.
 * If none of the handlers exists, the JVM writes the stack trace of the exception in the console and exits the program.
 *
 * Main class of the example. Initialize a Thread to process the uncaught
 * exceptions and starts a Task object that always throws an exception 
 *
 */
public class Main {

	/**
	 * Main method of the example. Initialize a Thread to process the 
	 * uncaught exceptions and starts a Task object that always throws an
	 * exception 
	 * @param args
	 */
	public static void main(String[] args) {
		// Creates the Task
		Task task=new Task();
		// Creates the Thread
		Thread thread=new Thread(task);
		// Sets the uncaught exception handler
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		// Starts the Thread
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Thread has finished\n");

	}

}
