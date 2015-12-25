package com.java.se7.cooked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex2
{
	public static void main(String[] args)
	{
		Pattern p = Pattern.compile(args[0]);
		Matcher m = p.matcher(args[1]);
		while(m.find())
		{
			System.out.print(m.start());
		}
	}
}



/*
Without group

C:\Java>java Regex2 "\d*" "ab34ef"               012456                            a b 3 4 e f
                                                                                   0 1 2 4 5 6 
	
C:\Java>java Regex2 "\d*" "ab324ef"              012567                            a b 3 2 4 e f  
                                                                                   0 1 2 5 6 7
	
C:\Java>java Regex2 "\d*" "ab345ef"              012567                            a b 3 4 5 e f
                                                                                   0 1 2 5 6 7

C:\Java>java Regex2 "\d*" "ab3456ef"             012678                            a b 3 4 5 6 e f
                                                                                   0 1 2 6 7 8 

C:\Java>java Regex2 "\d*" "abef"                 01234                             a b e f
                                                                                   0 1 2 3 4


With Group
With group, just insert the digits where they occur but after counting their first index.
C:\Java>java Regex2 "\d*" "ab34ef"               01234456                          a b 3 4 e f
                                                                                   0 1 2 3 4 4 5 6

C:\Java>java Regex2 "\d*" "ab324ef"              012324567                         a b 3 2 4 e f
                                                                                   0 1 2 3 2 4 5 6 7

C:\Java>java Regex2 "\d*" "ab345ef"              012345567                         a b 3 4 5 e f 
                                                                                   0 1 2 3 4 5 5 6 7

C:\Java>java Regex2 "\d*" "ab3456ef"             0123456678                        a b 3 4 5 6 e f
                                                                                   0 1 2 3 4 5 6 6 7 8 

C:\Java>java Regex2 "\d*" "abef"                 01234                             a b e f 
                                                                                   0 1 2 3 4 




*/
