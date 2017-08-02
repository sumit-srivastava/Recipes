package com.java.se7.data.structures.algos.pq;


import com.java.se7.data.structures.list.PositionalList;
import com.java.se7.data.structures.queue.PriorityQueue;

public class PQSort {
  /** Sorts sequence S, using initially empty priority queue P to produce the order. */
  public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E,?> P) {
    int n = S.size();
    for (int j=0; j < n; j++) {
      E element = S.remove(S.first());
      P.insert(element, null);             // element is key; null value
    }
    for (int j=0; j < n; j++) {
      E element = P.removeMin().getKey();
      S.addLast(element);                  // the smallest key in P is next placed in S
    }
  }
}
