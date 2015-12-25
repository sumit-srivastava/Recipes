package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class FactorialRecursive
{
	public static void main(String[] args)
	{
		int n;
		try
		{
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Enter the number : ");
			n = Integer.parseInt(br.readLine());
			System.out.println("The Factorial of the number " +n+ " is : " +fact(n));
		}
		catch(Exception e) {}
	}
	
	 static int fact( int a)
	{
		if(a==1)
			return 1;
		else
			return a*fact(a-1);
	}
}
