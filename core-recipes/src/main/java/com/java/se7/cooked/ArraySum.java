package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ArraySum
{
	public static void main(String[] args)
	{
		try
		{
			int[] a = new int[50];
			int s = 0,i = 0, n = 0;
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Enter number of elements :");
			n = Integer.parseInt(br.readLine());
			System.out.println("Enter the elements :");
			for(i=0; i<n; i++)
			{
				a[i] = Integer.parseInt(br.readLine());
			}
			System.out.print("The sum of all elements is :");
			for(i=0; i<n; i++)
			{
				s = s + a[i];
			}
			System.out.println(s);
		}
		catch(Exception e) {}
	}
}
