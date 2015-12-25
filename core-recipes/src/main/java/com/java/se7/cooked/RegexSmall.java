package com.java.se7.cooked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexSmall
{
	public static void main(String[] args)
	{
		// the expression to be matched
		Pattern p = Pattern.compile("ab");
		
		// the source to be matched from
		Matcher m = p.matcher("abaaaba");
		
		while(m.find())
		{
			System.out.print(m.start() + " ");
		}
	}
}
