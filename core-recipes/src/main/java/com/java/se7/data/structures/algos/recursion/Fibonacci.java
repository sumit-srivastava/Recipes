package com.java.se7.data.structures.algos.recursion;

/**
 * Demonstration of two recursive approaches to computing Fibonacci numbers.
 *
 */
public class Fibonacci {

  /** Returns the nth Fibonacci number (inefficiently).
   *
   * Fn, depends on the two previous values, Fn?2 and Fn?1. But notice that after computing Fn?2, the call to
   * compute Fn?1 requires its own recursive call to compute Fn?2, as it does not have knowledge of the value of
   * Fn?2 that was computed at the earlier level of recursion. That is duplicative work. Worse yet, both of those
   * calls will need to (re)compute the value of Fn?3, as will the computation of Fn?1. This snowballing effect is
   * what leads to the exponential running time of fibonacciBad.
   *
   * */
  public static long fibonacciBad(int n) {
    if (n <= 1)
      return n;
    else
      return fibonacciBad(n-2) + fibonacciBad(n-1);
  }

  /** Returns array containing the pair of Fibonacci numbers, F(n) and F(n-1).
   *
   * We can compute Fn much more efficiently using a recursion in which each invocation makes only one recursive call.
   * To do so, we need to redefine the expectations of the method. Rather than having the method return a single value,
   * which is the nth Fibonacci number, we define a recursive method that returns an array with two consecutive
   * Fibonacci numbers {Fn, Fn?1}, using the convention F?1 = 0.
   *
   * Although it seems to be a greater burden to report two consecutive Fibonacci numbers instead of one, passing
   * this extra information from one level of the recursion to the next makes it much easier to continue the process.
   * (It allows us to avoid having to recompute the second value that was already known within the recursion.)
   *
   * In terms of efficiency, the difference between the bad and good recursions for this problem is like night and day.
   * The fibonacciBad method uses exponential time. We claim that the execution of method fibonacciGood(n) runs in O(n)
   * time. Each recursive call to fibonacciGood decreases the argument n by 1; therefore, a recursion trace includes a
   * series of n method calls. Because the nonrecursive work for each call uses constant time, the overall computation
   * executes in O(n) time.
   *
   * */
  public static long[] fibonacciGood(int n) {
    if (n <= 1) {
      long[] answer = {n, 0};
      return answer;
    } else {
      long[] temp = fibonacciGood(n - 1);            // returns $\{ F_{n-1},\, F_{n-2} \}$
      long[] answer = {temp[0] + temp[1], temp[0]};  // we want $\{ F_{n},\, F_{n-1} \}$
      return answer;
    }
  }

  /** Don't call this (infinite) version. */
  public static int fibonacci(int n) {
    return fibonacci(n);      // After all $F_n$ does equal $F_n$
  }

  public static void main(String[] args) {
    final int limit = 50;

    System.out.println("The good...");
    for (int n = 0; n < limit; n++)
      System.out.println(n + ": " + fibonacciGood(n)[0]);

//    System.out.println();
//    System.out.println("The bad...");
//    for (int n = 0; n < limit; n++)
//      System.out.println(n + ": " + fibonacciBad(n));

    // Even worse...
//    fibonacci(10); // the infinite one
  }

}
