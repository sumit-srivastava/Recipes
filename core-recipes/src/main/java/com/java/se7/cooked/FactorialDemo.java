package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class FactorialDemo
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the number :");
			int a = Integer.parseInt(br.readLine());
			int fact = 1;
			System.out.print("Factorial of " +a+ ":");
			while(a>0)
			{
				fact = fact*a;
				a--;
			}
			System.out.println(fact);
		}
		catch(Exception e) {}
	}
}
