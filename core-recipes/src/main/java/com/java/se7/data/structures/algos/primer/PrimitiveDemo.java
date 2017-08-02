package com.java.se7.data.structures.algos.primer;

/**
 * A demonstration of primitive types.
 *
 */
public class PrimitiveDemo {
  public static void main(String[] args) {
    boolean flag = true;
    boolean verbose, debug;                // two variables declared, but not yet initialized
    char grade = 'A';
    byte b = 12;
    short s = 24;
    int i, j, k = 257;                     // three variables declared; only k initialized
    long l = 890L;                         // note the use of "L" here
    float pi = 3.1416F;                    // note the use of "F" here
    double e = 2.71828, a = 6.022e23;      // both variables are initialized
    System.out.println("flag = " + flag);  // the "+" is string concatenation
    System.out.println("grade = " + grade);
    System.out.println("s = " + s);
    System.out.println("k = " + k);
    System.out.println("l = " + l);
    System.out.println("pi = " + pi);
    System.out.println("e = " + e);
    System.out.println("a = " + a);
  }
}

/*
Output of main:

          flag = true
          ch = A
          b = 12
          s = 24
          i = 257
          l = 890
          f = 3.1416
          d = 2.71828
*/

