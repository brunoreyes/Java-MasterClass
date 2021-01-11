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

        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while(matcher8.find()) {
            System.out.println("Occurrence: " + matcher8.group(1));
        }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher9.find()) {
            System.out.println("Occurrence: " + matcher9.group(1));
        }

        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher10 = pattern10.matcher(challenge10);
        while(matcher10.find()) {
            System.out.println("Occurrence: start = " + matcher10.start(1) + " end = " + (matcher10.end(1) -1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while(matcher11.find()) {
            System.out.println("Occurrence: " + matcher11.group(1));
        }
        System.out.println("*********************");

        String challenge11a = "{0, 2}, {0, 5}, {1, 3}, {2, 4} {x, y}, {6, 34}, {11, 12}";
        Pattern pattern11a = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher11a = pattern11a.matcher(challenge11a);
        while(matcher11a.find()) {
            System.out.println("Occurrence: " + matcher11a.group(1));
        }

        String challenge12ZipCode = "11111";
        String challenge12ZipCodeRegEx = "^\\d{5}$";
        System.out.println(challenge12ZipCode.matches(challenge12ZipCodeRegEx));

        String challenge13ZipCode = "11111-1111";
        String challenge13ZipCodeRegEx = "^\\d{5}-\\d{4}?$"; // ?: 1 or more occurrences of numbers to 4
        System.out.println(challenge13ZipCode.matches(challenge13ZipCodeRegEx));

    }
}
