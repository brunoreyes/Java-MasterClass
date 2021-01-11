package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // 1. write the string literal regex (regular expression) that'll match this String: "I want a bike."
        String string1 = "I want a bike.";
        System.out.println(string1.matches("I want a bike.")); // output: true

        // 2. write a regex that matches "I want a bike" and "I want a ball"
        String string2 = "I want a ball.";
        // String regEx1 = "I want a \\w+."; // "\\w+."
        // "w" in "\\w+." stands for any char within a-z, A-Z or 0-9.
        // "+" in "\\w+." indicates wanting to match 1 or more chars before the period
        // "\\" indicates escaping the Char class (so we aren't matching w, but actually using w's method)
        String regEx1 = "I want a (bike|ball).";
        System.out.println(string1.matches(regEx1) && string2.matches(regEx1)); // output: true

        // 3. Utilize Matcher.matches() instead of string.matches() for the following problem above
        String bRegEx = "I want a \\w+.";
        Pattern bPattern = Pattern.compile(bRegEx);
        Matcher matcher = bPattern.matcher(string1);
        System.out.println(matcher.matches());
        // Remember: Each Matchers can only be used once, unless it is reset using the reset method
        // but here there's no need to reset the matcher, b/c I'm using different matcher instances
        matcher = bPattern.matcher(string2);
        System.out.println(matcher.matches());

        // 4. Replace all blanks with underscores
        String string3 = "Replace all blanks with underscores.";
        System.out.println(string3.replaceAll(" ", "_"));
       // System.out.println(string3.replaceAll("\\s","_")); // replacing all white space

        // 5. write a regex that matches the following string in it's entirety using String.matches
        String string4 = "aaabccccccccdddefffg";
        String regExOfString4 = "[abcedefg]+"; // matches Strings that contain 1 or more letters: a-g inclusive
        regExOfString4 = "[a-g]+";
        System.out.println(string4.matches(regExOfString4));

        // 6. matches the string above in it's entirety
        String exactRegExOfString4 = "^a{3}bc{8}d{3}ef{3}g$"; // matches the string in it's entirety

        // if replace all occurs then it means a complete replacement has occurred
        System.out.println(string4.replaceAll(regExOfString4,"Replaced"));

        // 7. Match a string that starts with series of letters, has a period & follows a series of digits
        String string5 = "abcd.135";
        String string5RegEx = "^[A-z]+\\.\\d+$";   // "d+" is all numbers 0-9, [A-z] for upper and lowercase
                   // since "." is a char class that matches all char, it has to be escaped with "\\."
        System.out.println(string5.matches(string5RegEx));
    }
}
