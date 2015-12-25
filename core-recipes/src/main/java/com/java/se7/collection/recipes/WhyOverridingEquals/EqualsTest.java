package com.java.se7.collection.recipes.WhyOverridingEquals;

public class EqualsTest
{
	public static void main(String[] args)
	{
		Moof one = new Moof(8);
		Moof two = new Moof(8);
		if(one.equals(two))
		{
			System.out.println("one and two are equal");
		}
		else
		{
			System.out.println("one and two are not equal");
		}
	}
}
class Moof 
{
	private int moofValue;
	Moof(int val)
	{
		moofValue = val;
	}
	public int getMoofValue()
	{
		return moofValue;
	}
	
	// the equals() in class Object uses only the == operator for comparisons
	// the == operator only when both reference refer to the same object.
	// You must override equals() to compare two objects to see if their contents are meaningfully equivalent.
	// String class an Wrapper classes have already overridden the equals().
	public boolean equals(Object o)
	{
		// if the object doesn't pass the instanceof test, the you'll get a runtime ClassCastException.
		if((o instanceof Moof) && (((Moof)o).getMoofValue() == this.moofValue))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
		
		
		
	
		
