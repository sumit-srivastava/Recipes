package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class BufferedReaderDemo
{
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader object = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter the number");
			int a= Integer.parseInt(object.readLine());
			int fact= 1;
			System.out.println("Factorial of " +a+ ":");
			for (int i= 1; i<=a; i++)
			{
				fact=fact*i;
			}
			System.out.println(fact);
		}
		catch (Exception e){}
	}
}
