package com.java.se7.collection.recipes.WhySet;

import java.util.*;

//when u don't want any duplicate.
class WhyTest {
	public static void main(String[] args) {
		boolean[] ba = new boolean[5];
		Set s = new HashSet(); // HashSets do not guarantee any ordering. If you
								// insert TreeSet, you'll get a
								// ClassCastException
		ba[0] = s.add("a"); // TreeSets guarantee ordering, for this, objects
							// should be mutually comparable.
		ba[0] = s.add(new Integer(42));
		ba[0] = s.add("b");
		ba[0] = s.add("a");
		ba[0] = s.add(new Object());
		for (int x = 0; x < ba.length; x++) {
			System.out.print(ba[x] + " ");
		}
		System.out.println("\n");
		for (Object o : s)
			System.out.print(o + " ");
	}
}
