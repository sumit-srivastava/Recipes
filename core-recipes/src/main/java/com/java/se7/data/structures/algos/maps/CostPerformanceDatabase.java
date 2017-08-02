package com.java.se7.data.structures.algos.maps;


import com.java.se7.data.structures.common.Entry;
import com.java.se7.data.structures.map.SortedMap;
import com.java.se7.data.structures.map.SortedTableMap;

/** Maintains a database of maximal (cost,performance) pairs. */
public class CostPerformanceDatabase {

  SortedMap<Integer,Integer> map = new SortedTableMap<>();

  /** Constructs an initially empty database. */
  public CostPerformanceDatabase() {}

  /** Returns the (cost,performance) entry with largest cost not exceeding c.
   * (or null if no entry exist with cost c or less).
   */
  public Entry<Integer,Integer> best(int cost) {
    return map.floorEntry(cost);
  }

  /** Add a new entry with given cost c and performance p. */
  public void add(int c, int p) {
    Entry<Integer,Integer> other = map.floorEntry(c); // other is at least as cheap
    if (other != null && other.getValue() >= p)       // if its performance is as good,
      return;                                         // (c,p) is dominated, so ignore
    map.put(c, p);                                    // else, add (c,p) to database
    // and now remove any entries that are dominated by the new one
    other = map.higherEntry(c);                       // other is more expensive than c
    while (other != null && other.getValue() <= p) {  // if not better performance
      map.remove(other.getKey());                     // remove the other entry
      other = map.higherEntry(c);
    }
  }

  private void sanity() {
    Integer oc=null, op=null;
    for (Entry<Integer,Integer> e : map.entrySet()) {
      if (op != null && e.getValue() <= op)
        System.out.println(String.format("(%d,%d) dominates (%d,%d)",oc,op,e.getKey(),e.getValue()));
    }
  }

  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (Entry<Integer,Integer> e : map.entrySet())
      sb.append(" (" + e.getKey() + "," + e.getValue() + ")");
    return sb.toString();
  }

  public static void main(String[] args) {
    CostPerformanceDatabase database = new CostPerformanceDatabase();

    int[][] sample = { {10,20}, {20,30}, {30,40}, {40,50}, {50,60}, {60,70}, {70,80}, {80,90},
                       {100,5}, {100,90}, {100,85}, {65,5}, {65,85}, {35,100}, {1,100} };

    for (int[] pair : sample) {
      database.add(pair[0], pair[1]);
      database.sanity();
      System.out.println(database);
    }
  }
}

