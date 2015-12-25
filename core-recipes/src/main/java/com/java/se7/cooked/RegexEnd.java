package com.java.se7.cooked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexEnd
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
			System.out.println(m.end() + " " + m.group());
		}
	}
}

                 /*
				  match pattren --  ".*xx" "yyxxxyxx"   // not clear
									 ".*?xx" "yyxxxyxx" // not clear
									 "\d" "yyxxxyxx"    // not clear
									 "a.c" "ac abc a c" // not clear
									 ".*?xx" "yyxxxyxx" // not clear
				*/

	
	
	
