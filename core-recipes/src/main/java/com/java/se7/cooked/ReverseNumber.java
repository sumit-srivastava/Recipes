package com.java.se7.cooked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ReverseNumber
{
	public static void main(String[] args)
	{
		int n, r, s = 0;
		try
		{
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			System.out.println("Enter the number : ");
			n = Integer.parseInt(br.readLine());
			while(n>0)
			{
				r = n%10;
				n = n/10;
				s = s*10 + r;
			}
			System.out.println("The reverse number is : " +s);
		}
		catch(Exception e){}
	}
}
