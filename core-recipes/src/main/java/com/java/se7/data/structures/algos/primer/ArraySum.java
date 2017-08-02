package com.java.se7.data.structures.algos.primer;

/**
 * Example of a static method that analyzes an array
 *
 */
public class ArraySum {

  public static double sum(double[] data) {
    double total = 0;
    for (int j=0; j < data.length; j++)        // note the use of length
      total += data[j];
    return total;
  }
}
