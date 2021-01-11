package com.company;

public class Main {

    public static void main(String[] args) {
        // Using IntelliJ's IDE debugger: click debug bug icon next to code run
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);
    }
}
