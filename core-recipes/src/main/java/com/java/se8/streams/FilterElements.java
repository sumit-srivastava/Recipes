package com.java.se8.streams;

import java.util.Arrays;
import java.util.List;

public class FilterElements {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        filterEvenElements(numbers);

        System.out.println("---------");

        filterEvenUniqueElements(numbers);
    }

    private static void filterEvenElements(List<Integer> list) {
        list.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    private static void filterEvenUniqueElements(List<Integer> list) {
        list.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
