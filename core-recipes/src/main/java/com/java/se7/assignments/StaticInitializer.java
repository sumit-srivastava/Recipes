package com.java.se7.assignments;

class StaticInitializer
{
	static int x;
	int y;
	
	static 
	{
		x = 7;
		System.out.println("Within Static Initializer x = " + x);
	}
	public static void main(String[] args)
	{
		new StaticInitializer().go();
		
	}
	void go()
	{
		y = 8;
		x = 6;
		System.out.println("Within main() -- x = " + x + " and y = " + y);
	}
}
