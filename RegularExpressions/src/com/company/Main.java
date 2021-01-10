package com.company;

public class Main {

    public static void main(String[] args) {
        // regular expressions are ofter use to search strings for a specific pattern

        String string = "I am a string. Yes, I am";
        System.out.println(string);
        // replaceAll() accepts a regular expression that describes the pattern I want to replace
        // as the first parameter, while the second parameter is the actual replacement String
        String yourString = string.replaceAll("I", "You"); // replaceAll is case-sensitive
        System.out.println(yourString);

        // character classes, boundary matches, and matching occurrences are just some things
        // that regular expressions can do .

        // Character class is like a wild card, representing a set or class of characters
        // Boundary matchers looks for boundaries such as the beginning/end of a string or a certain word or char
        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));
        // "." matches any char so output: YYYYYYYYYYYYYYYYYYYYYYY

        System.out.println(alphanumeric.replaceAll("^abcDee","YYY"));
        // replacing one pattern at the start of a String using upper char (^) with another String

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("abcDee", "YYY"));
        // replacing all patterns of a String with another String. Notice no "^" char: YYYeF12GhhYYYeiiiijkl99z

    }
}
