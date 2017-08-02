package com.java.se7.data.structures.algos.primer;

/**
 * An integer counter that can be incremented and reset to zero.
 *
 */
public class Counter {

  private int count;                           // a simple integer instance variable

  /** Constructs a new Counter with value zero. */
  public Counter() { }                         // default constructor (count is 0)

  /** Constructs a new Counter with given initial value. */
  public Counter(int initial) { count = initial; }     // an alternate constructor

  /** Returns the current count. */
  public int getCount() { return count; }                  // an accessor method

  /** Increments the count by one. */
  public void increment() { count++; }                     // an update method

  /** Increments the count by the specified delta. */
  public void increment(int delta) { count += delta; }     // an update method

  /** Returns the count to zero. */
  public void reset() { count = 0; }                       // an update method
}
