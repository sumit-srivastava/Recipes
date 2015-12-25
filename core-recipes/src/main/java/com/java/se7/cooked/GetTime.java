package com.java.se7.cooked;

import java.util.Date;

class GetTime
{
	public static void main(String[] args)
	{
		//Instantiate object of Date class
		Date date = new Date();
		System.out.println(date);
		long primVar = date.getTime();
		System.out.println(primVar);
	}
}
