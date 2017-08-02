package com.java.se7.data.structures.algos.primer;

/**
 * Example of a static method that analyzes an array using for-each loop.
 *
 */
public class ArraySumForeach {

  public static double sum(double[] data) {
    double total = 0;
    for (double val : data)   // Java's for-each loop style
      total += val;
    return total;
  }

}
