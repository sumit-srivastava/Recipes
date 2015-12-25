package com.java.se8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * return a list of all the unique characters for a list of words
 */
public class ExtractElements {

    public static void main(String[] args) {
        String[] arrayOfWords = {"Hello", "World"};
        List<String> wordsList = Arrays.asList(arrayOfWords);

        /* the lambda passed to the map method returns a String[] (an array of String) for each word.
         * So the stream returned by the map method is actually of type Stream<String[]>.
         * What you really want is Stream<String> to represent a stream of characters.
         */
        List<String[]> uniqueChars =  wordsList.stream()
                .map(word -> word.split(""))    // Incorrect use of map to find unique characters from a list of words
                .distinct()
                .collect(toList());

        // Attempt using map and Arrays.stream

        /* First, you need a stream of characters instead of a stream of arrays.
         * There’s a method called Arrays.stream()that takes an array and produces a stream
         */
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        List<Stream<String>> uniqueChars2 = streamOfWords.map(word -> word.split(""))   // converts each word into an array of its individual letters
                 .map(Arrays::stream)           // makes each array into a separate stream
                 .distinct()
                 .collect(toList());            // The current solution still doesn’t work! This is because you now end up with a list of streams

        List<String> uniqueChars3 = streamOfWords.map(word -> word.split(""))   // converts each word into an array of its individual letters
                .flatMap(Arrays::stream)           // flattens each generated stream into a single stream
                .distinct()
                .collect(toList());
    }
}
