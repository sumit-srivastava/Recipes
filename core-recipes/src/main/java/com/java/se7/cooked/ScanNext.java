package com.java.se7.cooked;

import java.util.Scanner;

class ScanNext
{
	public static void main(String[] args)
	{
		boolean b;
		String s, hits = " ";
		Scanner s1 = new Scanner(args[0]);
		while(b = s1.hasNext())
		{
			s = s1.next();
			System.out.println(s);
			hits += "s";
		}
		System.out.println("hits " + hits);
	}
}
