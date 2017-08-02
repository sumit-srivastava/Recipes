package com.java.se7.cooked;

/**
 * Finding Greatest Common Divisors
 *
 * The greatest common divisor (GCD) of two integers is the largest integer that evenly divides
 * both of the numbers. For example, GCD(60, 24) is 12 because 12 is the largest integer that
 * evenly divides both 60 and 24.
 *
 */
public class GCDFinder {

  public static void main(String[] args) {
    getGCD();
  }

    /*
      Algorithm::::
      ======================================
      Integer: GCD(Integer: A, Integer: B)
        While (B != 0)
            Integer: remainder = A Mod B
            // GCD(A, B) => GCD(B, remainder)
            A = B
            B = remainder
        End While
        Return A
      End GCD
  */
  /**
   * This algorithm is quite fast because the value B decreases by at least a factor of 1/2 for
   * every two trips through the While loop. Because the size of B decreases by a factor of at
   * least 1/2 for every two iterations, the algorithm runs in time at most O(log B).
   */

  private static void getGCD() {
    int a = 4851;
    int b = 3003;
    int remainder = 0;

    while (b != 0) {
      remainder = a % b;
      a = b;
      b = remainder;
    }
    System.out.print(a);
  }
}
