package com.java.se7.assignments;

class ScopeErrors
{
	public static void main(String[] args)
	{
		ScopeErrors s = new ScopeErrors();
		s.go();
	}
	void go()
	{
		int y = 5;
		go2();
		y++;
	}
	void go2()
	{
//		y++;		// won't compile, y is local to go().
	}
}
	
