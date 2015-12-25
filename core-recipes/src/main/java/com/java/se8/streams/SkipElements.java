package com.java.se8.streams;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SkipElements {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)    // skips the first two dishes that have more than 300 calories and returns the rest.
                .collect(toList());

//        dishes.stream()
//                .forEach(System.out::println);

        dishes.stream()
                .forEach(d -> {
                    System.out.print(d.getName() + ": ");
                    System.out.println(d.getName().length());
                });
    }
}
