package com.java.se7.collection.recipes.WhyOverridingToString;

public class BobTest
{
	public static void main(String[] args)
	{
		Bob f = new Bob("GoBobGo", 19);
		System.out.println(f);
	}
}
class Bob
{
	int shoeSize;
	String nickName;
	Bob(String nickName, int shoeSize)
	{
		this.shoeSize = shoeSize;
		this.nickName = nickName;
	}
	
	// to read something meaningful about the object of your class.
	public String toString()              
	{
		return ("I am a Bob, but you can call me " + nickName + ". My ShoeSize is " +shoeSize);
	}
}
