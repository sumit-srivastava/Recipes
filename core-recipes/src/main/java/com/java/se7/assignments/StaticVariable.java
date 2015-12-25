package com.java.se7.assignments;

class StaticVariable
{
	static int size = 7;
	static void changeIt(int size)
	{
		size = size + 200;
		System.out.println("size in changeIt is " + size);
	}
	public static void main(String[] args)
	{
//		StaticVariable sv = new StaticVariable();
		System.out.println("size " + size);
		changeIt(size);
		System.out.println("size after changeIt is " + size);
	}
}
