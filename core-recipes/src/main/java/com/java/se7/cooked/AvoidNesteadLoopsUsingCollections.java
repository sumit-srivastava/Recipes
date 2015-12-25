package com.java.se7.cooked;

import java.util.HashSet;
import java.util.Set;

/**
 * Finds out the Duplicates is String Array using Collection Framework.
 *
 * @author JavaTutorials
 * @since version 1.0
 */
public class AvoidNesteadLoopsUsingCollections {

    /**
     * Declare a String Array
     */
    private static String[] strArray = {"Cat", "Dog", "Tiger", "Lion", "Lion"};

    /**
     * @param args
     */
    public static void main(String[] args) {
        isThereDuplicateUsingSet(strArray);

    }

    /**
     * Iterates the String array and find out the duplicates in Array
     *
     * @param strArray Array of values to find the duplicates
     */
    public static void isThereDuplicateUsingSet(String[] strArray) {

        boolean duplicateFound = false;
        int loopCounter = 0;

        Set setValues = new HashSet();

        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];

            if (setValues.contains(str)) {
                duplicateFound = true;
                System.out.println("Duplicates Found for " + str);
            }
            setValues.add(str);

            loopCounter++;

            if (duplicateFound) {
                break;
            }
        }// end of for loop

        System.out.println("Looped " + loopCounter
            + " times to find the result");
    }

}
