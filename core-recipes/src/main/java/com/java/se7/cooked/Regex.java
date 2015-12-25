package com.java.se7.cooked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex
{
	public static void main(String[] args)
	{
		// the expression to be matched
		Pattern p = Pattern.compile(args[0]);
		
		// the source to be matched from
		Matcher m = p.matcher(args[1]);
		System.out.println("Pattern is " + m.pattern());
		while(m.find())
		{
			System.out.println(m.start() + " " + m.group());  // when m.group() is used, the searched value is shown just after the index it was found on.
		}
	}
}

                 /*
				  match pattren --  ".*xx" "yyxxxyxx"
									 ".*?xx" "yyxxxyxx"
									 "\d" "yyxxxyxx"
									 "a.c" "ac abc a c"
									 ".*?xx" "yyxxxyxx"
				*/

	
	
	
