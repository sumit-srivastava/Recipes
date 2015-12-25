package com.java.se7.string.recipes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find out if a String contains a very simple pattern.
 */
public class PatternMatchSolution {

    static boolean doesStringHasPattern(String givenString) {
        boolean doesStringHasPattern=false;

        for(int i=0; i< (givenString.length()/2); i++){
            String t = givenString.substring(0, i+1);
            Pattern p = Pattern.compile(t);
            Matcher m = p.matcher(givenString);

            if (m.find()){
                String updatedStr = givenString.replaceAll(t, "");
                if (updatedStr.length() == 0) {
                    doesStringHasPattern = true;
                    break;
                }
            }
        }
        return doesStringHasPattern;
    }

    public static void main(String args[]){
        String str = new String("ababababababc");

        System.out.println(doesStringHasPattern(str));
    }
}
