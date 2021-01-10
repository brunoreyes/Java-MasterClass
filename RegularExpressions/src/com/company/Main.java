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

        // replaceAll()
        System.out.println(alphanumeric.replaceAll(".","Y"));
        // "." matches any char so output: YYYYYYYYYYYYYYYYYYYYYYY

        System.out.println(alphanumeric.replaceAll("^abcDee","YYY"));
        // replacing one pattern at the start of a String using upper char (^) with another String

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";

        // replacing all patterns of a String with another String. Notice no "^" char: YYYeF12GhhYYYeiiiijkl99z
        System.out.println(secondString.replaceAll("abcDee", "YYY"));

        System.out.println(secondString.replaceAll("ijkl99z$","The End"));// "$" : end boundary matcher
        // output: abcDeeeF12GhhiiiThe

        // replacing any occurrence of chars: "a", "e" or "i" with "X". Output: XbcDXXXF12GhhXbcDXXXXXXXjkl99z
        System.out.println(secondString.replaceAll("[aei]","X"));

        System.out.println(secondString.replaceAll("[aei]","Replaced"));

        // only replacing "a", "e" or "i" with "X" if the "a", "e" or "i" were followed by "F" or "j"
        System.out.println(secondString.replaceAll("[aei][Fj]","X"));
//        output: abcDeeX12GhhabcDeeeiiiXkl99z


        // matches()
        System.out.println(alphanumeric.matches("^hello"));// return false b/c the regular expression (regex)
        // does not exist within the beginning of the String alphanumeric

        System.out.println(alphanumeric.matches("^abcDeee")); // returns false, b/c the whole String has to match
        // not just a part of the string like the beginning

        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z")); // returns true b/c the entire string matches

    }
}