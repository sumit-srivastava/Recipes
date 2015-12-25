package com.java.se7.concurrency.recipes.thread.management.finalization.using.interruption;

/**
 * Theory:
 *
 * There is an important difference between the isInterrupted() and
 * the interrupted() methods. The first one doesn't change the value
 * of the interrupted attribute, but the second one sets it to false. As
 * the interrupted() method is a static method, the utilization of the
 * isInterrupted() method is recommended.
 *
 *  This class generates prime numbers until is interrupted.
 */
public class PrimeGenerator extends Thread{

	/**
	 *  Central method of the class
	 */
	@Override
	public void run() {
		long number=1L;
		
		// This bugle never ends... until is interrupted
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime\n",number);
			}
			
			// When is interrupted, write a message and ends
			if (isInterrupted()) {
				System.out.printf("The Prime Generator has been Interrupted\n");
				return;
			}
			number++;
		}
	}

	/**
	 *  Method that calculate if a number is prime or not
	 * @param number : The number
	 * @return A boolean value. True if the number is prime, false if not.
	 */
	private boolean isPrime(long number) {
		if (number <=2) {
			return true;
		}
		for (long i=2; i<number; i++){
			if ((number % i)==0) {
				return false;
			}
		}
		return true;
	}

}
