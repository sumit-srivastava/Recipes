package com.java.se7.collection.recipes.WhySearchingThroughTreeSets;

import java.util.*;

class WhySearchingThroughTreeSets
{
	public static void main(String[] args)
	{
		TreeSet<Integer> times = new TreeSet<Integer>();
		times.add(1205);
		times.add(1505);
		times.add(1545);
		times.add(1830);
		times.add(2010);
		times.add(2100);
		
		// Java 5 Version
		
		TreeSet<Integer> subset = new TreeSet<Integer>();
		// b -- boolean argument is optional and lets specify whether the endpoint is optional
		// headSet(e, b) -- returns a subset ending at element e and exclusive of e
		subset = (TreeSet)times.headSet(1600);
		System.out.println("J5 - last before 4pm is: " + subset.last());
		
		TreeSet<Integer> subset2 = new TreeSet<Integer>();
		// tailSet(e, b) -- returns a subset starting at and inclusive of element e
		subset2 = (TreeSet)times.tailSet(2000);
		System.out.println("J5 - first after 8pm is: " + subset2.first());
		
		// Java 6 Version using the new Lower() and highr() methods
		
		System.out.println("J6 - last before 4pm is: " + times.lower(1600));
		System.out.println("J6 - first after 8pm is: " + times.higher(2000));
	}
}
