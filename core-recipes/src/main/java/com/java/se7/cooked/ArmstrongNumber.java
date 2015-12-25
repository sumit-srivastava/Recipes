package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ArmstrongNumber
{
	public static void main(String[] args)
	{
		int n, r, s = 0, t;
		try
		{
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Enter the number : ");
			n = Integer.parseInt(br.readLine());
			t = n;
			while(n>0)
			{
				r = n%10;
				n = n/10;
				s = s + r*r*r;
			}
			if( t==s)
				System.out.println("The number is armstrong");
			else
				System.out.println("The number is not armstrong");
		}
		catch(Exception e) {}
	}
}

