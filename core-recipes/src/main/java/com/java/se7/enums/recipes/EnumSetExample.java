package com.java.se7.enums.recipes;

import com.java.se7.enums.recipes.type2.Day;

import java.util.EnumSet;

/**
 * An EnumSet is a specialized Set implementation. All of the elements in an EnumSet must come from a single enum type
 * that is specified, explicitly or implicitly, when the set is created.
 * EnumSet are represented internally as bit vectors. Also, an iterator traverses the elements in their natural order.
 */
public class EnumSetExample {
	public static void main(String[] args) {
		// Create an EnumSet that contains all days of the week.
		EnumSet<Day> week = EnumSet.allOf(Day.class);
		
		// Print the values of an EnumSet.
		for(Day d: week)
			System.out.println(d.name());
		
		System.out.println(week.size());
		
		// Remove a Day object.
		week.remove(Day.FRIDAY);
		System.out.println("After removing Day.FRIDAY, size: " + week.size());
		
		// Insert a Day object.
		week.add(Day.valueOf("FRIDAY"));
		System.out.println("Size is now: " + week.size());
	}
}
