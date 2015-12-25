package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class EvenOdd
{
	public static void main(String[] args)
	{
		int n, r;
		try
		{
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Enter the number : ");
			n = Integer.parseInt(br.readLine());
			r = n%2;
			if(r==0)
				System.out.println("Number is even");
			else
				System.out.println("Number is odd");
		}
		catch(Exception e){}
	}
}
