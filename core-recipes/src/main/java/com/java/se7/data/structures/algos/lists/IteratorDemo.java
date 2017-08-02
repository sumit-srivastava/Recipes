package com.java.se7.data.structures.algos.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IteratorDemo {

  public static void main(String[] args) {
    int N = 50;
    Random r = new Random();

    ArrayList<Double> data;      // populate with random numbers (not shown)

    data = new ArrayList<>(N);
    for (int i = 0; i < N; i++)
      data.add(r.nextGaussian());

    Iterator<Double> walk = data.iterator();
    while (walk.hasNext())
      if (walk.next() < 0.0)
        walk.remove();

    System.out.println("Length of remaining data set: " + data.size());
    System.out.println(data);

  }
}
