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
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);
    }
}
