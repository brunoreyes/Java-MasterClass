package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	    // Streams = a sequence of computations ( computational steps that are chained together)

        List<String> someBingoNumbers = Arrays.asList(
                "N40","B43","N32","I89","E39","R12","F24","G59","H74","U12","I36","O71");

        List<String> numbersStartingWithG = new ArrayList<>();
        someBingoNumbers.forEach(number -> { // for each number within Array someBingoNumbers
            // .startsWith method sees if the passed parameter "G" is the first char of number
            if (number.toUpperCase().startsWith("G")){
                numbersStartingWithG.add(number);
                System.out.println(number);
            }
        });

        numbersStartingWithG.sort((String s1, String s2) -> s1.compareTo(s2));
        numbersStartingWithG.forEach((String s) -> System.out.println(s));
    }
}
