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
        // removing the need for the curly braces because no longer specifying an exact value
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

            // "abc" "a", "b", and "c"
            // [H|h]arry
            System.out.println("harry".replaceAll("[H|h]arry", "Larry")); // replacing capitalized & lowercase versions
            System.out.println("Harry".replaceAll("[H|h]arry", "Larry")); // of harry

            // [^abc] means matches all characters but a, b, and c
            String tvTest = "tstvtkt";
//            String tNotVRegExp = "t[^v]";
            String tNotVRegExp = "t(?!v)"; // look ahead regular expression says we want "t" that isn't followed (not operator: "!") by a "v"
                                            // look ahead (!char) don't actually include the characters they match in the matched text
                                            // look ahead for including the char "v" after char "t": t(?=v)

            Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
            Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

            count = 0;
            while (tNotVMatcher.find()) {
                count++;        // Using regular expression: "t[^v]" to count each occurrence of "t" that isn't followed by "v"
                System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end()); // only 2 occurrences
                // because"[^v]" signifies it has to be followed by a char, but not "v", if no char after the t, then it doesn't count
                // each bracket ("[" & "]") requires char to be before or after a char
                // for instance "[apple" requires characters to come before apple
                // for instance "apple]" requires characters to come after apple
            }

            // validating a US Phone number
            // ^ : start, of instance, so if anything comes before the start of the phone number, it won't match
            // [\(] : Escaped starting parenthesis (used b/c the parenthesis is a char class used to indicate a group)
            // matching the parenthesis character's literal by escaping it in this way: "[\characterLiteral]"
            // [\)] : Escaped closing parenthesis
            // [\-] : Escaped dash
            // [ ] : Escaped space
            // {#} : quantifier that indicates the number of the char that came before the quantifier:
            // for ex [0-9]{3}, here the quantifier is set to 3, so 3 numbers ranging from 0-9 follow like "295" or "001"
            // [0-9] : provides an inclusive range of numbers from 0-9
            // $ : end of instance, so if anything follows the end of the phone number, it won't match
            // ^([\(]{1}[0-9]{3}[\)][0-9]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$

            String phone1 = "098) 765-4321"; // should not match, missing starting area code parenthesis: (###
            String phone2 = "098) 765 4321"; // should not match, missing area code parenthesis: (### & dash: "-"
            String phone3 = "098)765-4321"; // should not match, missing area code parenthesis: (### & space: " "
            String phone4 = "098)7654321"; // should not match, missing area code parenthesis: (###, dash: "-" & space: " "
            String phone5 = "(098 765-4321"; // should not match, missing ending area code parenthesis: ###)
            String phone6 = "(098 765-4321"; // should not match, missing area code parenthesis: ###) & space: " "
            String phone7 = "(098 7654321"; // should not match, missing area code parenthesis: ###) & dash: "-"
            String phone8 = "(098 765 4321"; // should not match, missing area code parenthesis: ###), dash: "-" & space: " "
            String phone9 = "098 765-4321"; // should not match, missing starting and ending area code parenthesis: (###)
            String phone10 = "098765 4321"; // should not match, missing area code parenthesis: (###) & dash: "-"
            String phone11 = "098 7654321"; // should not match, missing area code parenthesis: (###) & space: " "
            String phone12 = "0987654321"; // should not match, missing area code parenthesis: (###), dash: "-" & space: " "
            String phone13 = "(098)7654321"; // should not match, missing dash: "-" & space: " "
            String phone14 = "(098)765-4321"; // should not match, missing space: " "
            String phone15 = "(123) 4567890"; // should not match, missing dash: "-"
            String phone16 = "(1a3) 456-7890"; // should not match, in the first [0-9]{3} instance, there's a non-number char
            String phone17 = "(123) 4b6-7890"; // should not match, in second [0-9]{3} instance, there's a non-number char
            String phone18 = "(123) 426-7c90"; // should not match, in the [0-9]{4} instance, there's a non-number char
            String phone19 = "1(123) 426-7c90"; // should not match, theres a char coming before the phone number
            String phone20 = "(123) 426-79011"; // should not match, theres a char coming after the phone number
            String phone21 = "(123) 426 79011"; // should not match, space: " " in place of "-"
            String phone22 = "(123)-426 7901"; // should not match, space: "-" in place of " "
            String phone23 = "(123) 426 - 9011"; // should not match, extra space: " "
            String phone24 = "(123) 426-9011"; // should match
            String phone25 = "(098) 765-4321"; // should match

            // the following unit test produce an output of false
            System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\){1}][ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone5 = " + phone5.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone6 = " + phone6.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone7 = " + phone7.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone8 = " + phone8.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone9 = " + phone9.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone10 = " + phone10.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone11 = " + phone11.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone12 = " + phone12.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone13 = " + phone13.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone14 = " + phone14.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone15 = " + phone15.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone16 = " + phone16.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone17 = " + phone17.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone18 = " + phone18.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone19 = " + phone19.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone20 = " + phone20.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone21 = " + phone21.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone22 = " + phone22.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone23 = " + phone23.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

            // the following unit test produce an output of true
            System.out.println("phone24 = " + phone24.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
            System.out.println("phone25 = " + phone25.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

            // ^4[0-9]{12}([0-9]{3})?$
            String visa1 = "4444444444444"; // should match bc it starts with a "4": ^4
                                            // then has 12 [0-9] chars that follow: [0-9]{12}
                                            // and an optional 0 to 3 occurrences of numbers ranging from 0-9: ([0-9]{3}?)
                                            // ? signifies it could be none of some but the {3} limits it to 3

            String visa2 = "5444444444444"; // shouldn't match

            // should match: 15 chars total (one "4" at the start beginning, followed by 12 numbers, followed by 0-3 optional numbers, ending)
            String visa3 = "4444444444444444";

            String visa4 = "44444444444444444";  // should not match, bc the optional numbers could only go up to 3 ( here, it's 4)
            String visa5 = "4444";  // shouldn't match

            System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
            System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
            System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
            System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
            System.out.println("visa5 " + visa5.matches("^4[0-9]{12}([0-9]{3})?$"));



        }
    }

}
