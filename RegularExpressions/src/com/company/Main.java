package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        // converting a name from up/low case to uppercase using either instance h or H following the String: arry
        System.out.println("harry".replaceAll("[Hh]arry","Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";

        // replacing everything from the start of the String except chars: "e" or "j"
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));

        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]","X"));
        // is the same as using "-" as a range :
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]","X"));

        // To replace lowercase and capital letters as well
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]","X"));

        // "?i" is used to ignore case so both "a" and "A" would be replaced
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        //  to take into account for a unicode String: ?ui
        System.out.println(newAlphanumeric.replaceAll("(?iu)[a-f3-8]", "X"));

        // replacing all the numbers in a string using [0-9]
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        // or short hand: \\d
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));

        // replacing all non-digits using \\D
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I have blank spaces,\ta tab, and also a newline\n";

        // removing all white space, tabs, and new lines within a String using: \\s
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));

        // removing all tabs
        System.out.println(hasWhiteSpace.replaceAll("\t","X"));

        // replace all non-white space characters, only tab and new line chars remain
        System.out.println(hasWhiteSpace.replaceAll("\\S",""));

        // replace all a-z, A-z, 0-9, and _ using \\w
        System.out.println(hasWhiteSpace.replaceAll("\\w","X"));

        // replacing anything but: a-z, A-z, 0-9, and _ using \\W
        System.out.println(hasWhiteSpace.replaceAll("\\W","X"));

        // replacing word boundaries of " word " with "x": " xwordx ": \\b (nice to add tags with)
        System.out.println(hasWhiteSpace.replaceAll("\\b","X"));

        // a Quantifier specifies how often an element in a regular expression (regex) can occur

        // {3} specifies the number of the preceding char (e) that must occur (so eee) to find a match
        // Remember: the quantifier({#}) always comes after the character that it applies to.
        System.out.println(alphanumeric.replaceAll("^abcDe{3}","YYY"));

        // replaceAll strings with abcDe and all the preceding e's using "+" like so: "thisIsAString+"
        // removing the need for the curly braces becuase no longer specifying an exact value
        System.out.println(alphanumeric.replaceAll("^abcDe+","YYY"));

        // replacing all string patterns with 0 or all of the preceding character: "e" using "*"
        // this replaceAll will also remove "abcD" because it's either with all consecutive e's or without the e at all
        System.out.println(alphanumeric.replaceAll("^abcDe*","YYY"));

        // replacing strings that are followed by the range of 2-5 e's (only works if it's between 2-5 e's so not 1 e)
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}","YYY"));

       // replacing any occurrence of "h" followed by any # of i's, followed by at least 1 j replaced all that by a Y
        System.out.println(alphanumeric.replaceAll("h+i*j","Y"));

        // matches is used to find multiple patterns within a string

        // Utilizing a stringBuilder to create a long string
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub Header</h2>");
        htmlText.append("<p>A Paragraph</p>");
        htmlText.append("<p>Another paragraph</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");


        // Using matcher to find any h2 tags within text
//        String h2Pattern = ".*<h2>.*"; // "." = any character, "*" = 0 or more characters
        // together .* = there can be anything before or after h2 , but this is only to find one instance

        String h2Pattern = "<h2>"; // to find all instances of <h2>, remove .* on both sides

        // Checking if the pattern matches the regex (regular expression)
//        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
                                                        // ignoring case         checking unicode case
        // Matcher used to find if there is any <h2> tags within text
        // Pattern compiles the pattern we are looking for ("<h2>") to create a pattern instance
        // that we can use to create a Matcher instance that checks for the pattern (Pattern instance)
        // and sees if it matches any pattern within the String htmlText.
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());
        // Remember: Each Matchers instances can only be used once, unless it is reset using the reset method
        matcher.reset();


        // Using the find, start and end methods to find out the # & position of occurrences within a String

        int count = 0;
        while (matcher.find()){
            // Adding each occurrence to the counter
            count++;                                      // matcher.start() & .end() return starting & ending indexes
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end() );
        }
                                // group 1: (<h2>.*?</h2>)
        String h2GroupPattern = "(<h2>.*?</h2>)"; // want opening and closing tag and anything in between
                                                    // ? turns * quantifier into a lazy quantifier
                                                    // only getting what's within each instance of <h2> to </h2>
                                                    // and not <h2> to </h2> to <h2> to </h2>
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset(); // resetting the matcher to be able to use it again
        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1)); // only 1 group: (<h2>)
            // output:    Occurrence: <h2>Sub Header</h2>
                        //Occurrence: <h2>Summary</h2>
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)"; // group 1: (<h2>), group 2: (.+?), group 3: (</h2>)
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()){
            // gathering the text between the opening and closing tags and not the tags themselves
            System.out.println("Occurrence: " + h2TextMatcher.group(2)); // here we are getting group 2 (.+?)
        }
    }

}
