package com.java.se7.collection.recipes.WhyComparatorSearch;

import java.util.*;

class SearchObjArray
{
	public static void main(String[] args)
	{
		String[] sa = {"one", "two", "three", "four"};
		
		// sorting array alphabetically ( natural order )
		Arrays.sort(sa);
		for(String s: sa)
			System.out.println(s + " ");
		
		// search  for the location of element through binarySearch().
		// search  for the location of element "one".
		// successful searches return the int index of the element being searched.
		// unsuccessful searches return the int index that represents the insertion point.
		// positive return values and 0 indicate successful searches.
		// negative numbers to indicate insertion points.
		// the collection/array being searched must be sorted before u can search it, otherwise the results of the search will not be predictable.
		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));
		
		System.out.println("now reverse sort");
		ReSortComparator rs = new ReSortComparator();
		Arrays.sort(sa, rs);
		for(String s : sa)
			System.out.println(s + " ");
		
		// If the collection/array you want to search was sorted using a Comparator, it must be searched using the same Comparator.
		// Comparators cannot be used when searching arrays of primitives.
		System.out.println("\none = " + Arrays.binarySearch(sa, "one"));  // will give an incorrect answer.
		System.out.println("\none = " + Arrays.binarySearch(sa, "one", rs));
	}
	static class ReSortComparator implements Comparator<String>
	{
		public int compare(String a, String b)
		{
			return b.compareTo(a);
		}
	}
}


		
