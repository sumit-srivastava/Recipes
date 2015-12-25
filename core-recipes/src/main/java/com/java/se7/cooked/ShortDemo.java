package com.java.se7.cooked;

class ShortDemo
{
	public static void main(String[] args)
	{
		Short s1 = new Short((short)343);
		Short s2 = new Short((short)49);
		Short s3 = (short)((new Short((short)343)) / (new Short((short)49)));
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
