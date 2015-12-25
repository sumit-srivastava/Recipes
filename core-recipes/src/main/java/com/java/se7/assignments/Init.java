package com.java.se7.assignments;

class Init
{
	Init(int x)				// Instance init blocks run every time a class instance is created.
	{						// Instance init blocks run after the constructor's call to super().
		System.out.println("1-arg const");
	}
	Init()					
	{
		System.out.println("no-arg const");				// Init blocks execute in the order they appear.
	}
	static
	{
		System.out.println("1st static init");	// static init blocks run once, when the class is first loaded.
	}
	{
		System.out.println("1st instance init");
		System.out.println("2nd instance init");
	}
	static
	{
		System.out.println("2nd static init");
	}
	
	public static void main(String[] args)
	{
		new Init();
		new Init(7);
	}
}
