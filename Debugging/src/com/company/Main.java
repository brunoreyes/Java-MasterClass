package com.company;

public class Main {

    public static void main(String[] args) {
        // Using IntelliJ's IDE debugger: click debug bug icon next to code run

        // within debugger on bottom left is the frames section showing the execution stack trace.
        // everytime a frame is called it is added to the stack trace.
        // frames are called from bottom first to top last.
        // multiple threads can go through

        // on the bottom center we see the variables table showing variables of each class
        // instance variables have an expandable menu ">"

        // execution point: reveals where the code was suspended
        // step over: moves to the next line of code
        // step into: steps into any methods called by the next statement executed
        // force step into: goes into java's built in function
        // step out: run the rest of the method, return to the caller and suspend
        // run to cursor suspends on the line.

        // make sure to keep breakpoints to a minimum and make sure to get rid of them after debugging
        // and then you are free to run your code.

        // to see all break points or run debugger functionality go to the run menu on the tool bar
        // then go to "view breakpoints.." and uncheck/check breakpoints to hide/show breakpoints

        // var with glasses are watches, they are updated as application runs

        // within the variables list
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

        String str = "abcdefg";
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}
