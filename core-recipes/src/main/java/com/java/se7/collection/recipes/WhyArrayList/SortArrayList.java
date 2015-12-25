package com.java.se7.collection.recipes.WhyArrayList;

import java.util.*;

class SortArrayList
{
	public static void main(String[] args)
	{
		ArrayList<String> stuff = new ArrayList<String>();
		stuff.add("Denver");
		stuff.add("Boulder");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted " + stuff);
		
		// ArrayList doesn't give you any way to sort its contents, but the java.util.Collections class does.
		Collections.sort(stuff);
		System.out.println("sorted " + stuff);
	}
}
