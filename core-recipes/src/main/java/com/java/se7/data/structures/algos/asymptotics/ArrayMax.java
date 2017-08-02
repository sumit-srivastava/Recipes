package com.java.se7.data.structures.algos.asymptotics;

/**
 * Demonstration of algorithm for finding the maximum element of an array.
 *
 */
class ArrayMax {

  /** Returns the maximum value of a nonempty array of numbers. */
  public static double arrayMax(double[] data) {
    int n = data.length;
    double currentMax = data[0];     // assume first entry is biggest (for now)
    for (int j=1; j < n; j++)        // consider all other entries
      if (data[j] > currentMax)      // if data[j] is biggest thus far...
        currentMax = data[j];        // record it as the current max
    return currentMax;
  }

}
