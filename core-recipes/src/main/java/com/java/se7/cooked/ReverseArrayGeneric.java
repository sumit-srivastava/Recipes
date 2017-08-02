package com.java.se7.cooked;

import java.util.Arrays;

/**
 * Created by ssri52 on 2/24/2017.
 */
public class ReverseArrayGeneric {

    /**
     *
     *
     * @param data
     * @param <T>
     */
    public static <T> void reverse(T[] data) {
        int low = 0, high = data.length-1;
        while(low < high) {
            T temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseArrayGeneric reverseArrayGeneric = new ReverseArrayGeneric();
        String array[] = new String[]{"A","B","C"};
        reverseArrayGeneric.reverse(array);
        System.out.println(Arrays.toString(array));
    }
}
