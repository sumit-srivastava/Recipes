package com.java.se7.collection.recipes.WhyPriorityQueue;

import java.util.*;

class WhyPriorityQueue
{
	static class SortWhyPriorityQueue implements Comparator<Integer>
	{
		public int compare(Integer one, Integer two)
		{
			return two - one;
		}
	}
	public static void main(String[] args)
	{
		int[] ia = {1, 5, 3, 7, 6, 9, 8};  // unordered data
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		
		for(int x : ia)
			pq1.offer(x);		// offer() to add elements to PriorityQueue
		for(int x : ia)			// review queue
			System.out.print(pq1.poll() + " ");	// poll() returns the highest priority entry an removes the entry from the queue
		System.out.println(" ");
		
		SortWhyPriorityQueue swp = new SortWhyPriorityQueue();		// get a comparator
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, swp);
		
		for(int x : ia)
			pq2.offer(x);
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());
		System.out.println("size " + pq2.size());
		for(int x : ia)
			System.out.print(pq1.poll() + " ");
		
	}
}
