package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    // Streams = a sequence of computations ( computational steps that are chained together)

        List<String> someBingoNumbers = Arrays.asList(
                "N40","B43","N32","I89","E39","R12","F24","G59","H74","U12","I36","O71"
                ,"G53","G20","g49");

        List<String> numbersStartingWithG = new ArrayList<>();

//        someBingoNumbers.forEach(number -> { // for each number within Array someBingoNumbers
//            // .startsWith method sees if the passed parameter "G" is the first char of number
//            if (number.toUpperCase().startsWith("G")){
//                numbersStartingWithG.add(number);
//                System.out.println(number);
//            }
//        });
//
//        numbersStartingWithG.sort((String s1, String s2) -> s1.compareTo(s2));
//        numbersStartingWithG.forEach((String s) -> System.out.println(s));

        someBingoNumbers
                .stream() // returns a sequential stream of computations
                // each operation below should be seen an an independent step operating on a string argument
                // "::" is a method reference that can be utilized when a lambda calls an existing method
                .map(String::toUpperCase) // 1st: map through someBingoNumbers & return them all uppercase
                .filter(s->s.startsWith("G")) // 2nd: filtering the new mapped list for items start w/ "G"
                .sorted() // 3rd: sorting the filtered items that started with g in numerical order
                .forEach(System.out::println); // 4th: printing each item out in sorted order

        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71"); // streams can only contain 1 type
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);// concat adds the streams
//        System.out.println(concatStream.count()); //10
        // .distinct will get rid of duplicated and only show unique items
//        System.out.println(concatStream.distinct().count());  //6
        // .peak() reveals the items within the stream
        System.out.println(concatStream.distinct().peek(System.out::println).count());


    }
}

//        int sum = widgets.stream()
//                .filter(w -> w.getColor() == RED)
//                .mapToInt(w -> w.getWeight())
//                .sum();