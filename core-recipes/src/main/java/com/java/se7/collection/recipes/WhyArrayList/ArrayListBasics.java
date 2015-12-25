package com.java.se7.collection.recipes.WhyArrayList;

//Java.util.ArrayList class
// It can grow automatically.
// gives you fast iteration and fast random access
// ordered collection (by index) but not sorted
import java.util.*;

class ArrayListBasics
{
	public static void main(String[] args)
	{
		List<String> test = new ArrayList<String>();
		String s = "hi";
		test.add("string");
		test.add(s);
		test.add(s+s);
		System.out.println(test.size());
		System.out.println(test.contains(42));
		System.out.println(test.contains("hihi"));
		test.remove("hi");
		System.out.println(test.size());
	}
}
