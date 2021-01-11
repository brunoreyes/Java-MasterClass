package com.company;

import java.util.Locale;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;


    public void addChar(StringBuilder sBuilder, char c){
//        this.sBuilder.append(c); // fix debugging error and now updating the variable passed
        // to this method instead of the local instance variable ( by removing "this")
        sBuilder.append(c);
        charsAdded++;

    }

    public String upperAndPrefix(String str){
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }
    public String addSuffix(String str){
        return str + "_Suffix";
    }
}
