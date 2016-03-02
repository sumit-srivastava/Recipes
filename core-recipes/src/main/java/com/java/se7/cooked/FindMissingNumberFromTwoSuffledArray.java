package com.java.se7.cooked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sumitsrivastava
 */
public class FindMissingNumberFromTwoSuffledArray {

    public static void main(String[] args) {
        int[] arrayA = new int[]{4,1,0,2,9,6,8,7,5,3,11};
        int[] arrayB = new int[]{6,4,7,2,1,0,8,3,9};    // missing: 5, 11

        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < arrayB.length; i++) {
            if (occurrences.containsKey(arrayB[i])) {
                occurrences.put(arrayB[i], occurrences.get(arrayB[i]) + 1);
            } else {
                occurrences.put(arrayB[i], 1);
            }
        }
        int[] missingElements = new int[arrayA.length - arrayB.length];
        int counter = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (occurrences.containsKey(arrayA[i])) {
                if (occurrences.get(arrayA[i]) == 0) {
                    missingElements[counter] = arrayA[i];
                    counter++;
                } else {
                    occurrences.put(arrayA[i], occurrences.get(arrayA[i]) - 1);
                }
            } else {
                missingElements[counter] = arrayA[i];
                counter++;
            }
        }

        System.out.println("missingElements: " + Arrays.toString(missingElements));
    }
}
