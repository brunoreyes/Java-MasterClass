package com.company;

public class Utilities {


    // Returns a char array containing every nth char.
    // When sourceArray.length < n, return sourceArray
    public char[] everyNthChar(char[] sourceArray, int n){
        if (sourceArray == null || sourceArray.length < n){
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;
        for (int i  = n-1; i  < sourceArray.length; i +=n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }
    // Removes pairs of the same character that are next to each other
    // by removing the nth occurrence of the next character
    //"ABBCDEEF" -> "ABCDEF"
    //"ABCBDEEF" -> "ABCBDEF" ( the two B's arent next to each other so they aren't removed)
    public String removePairs(String source){
        // if length is less than two there isn't any pairs
        if (source.length() < 2){
            return source;
        }
        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length - 1; i++) {
//            System.out.println(string[i]); // for testing purposes
            if (string[i] != string[i+1]){
                sb.append(string[i]);
            }
        }
        // add the final character, always safe
//        System.out.println(string[string.length - 1]); // for testing purposes
        sb.append(string[string.length - 1]);
        return sb.toString();
    }
    // perform a conversion based on some internal business rule
    public int converter(int a, int b){
        return (a/b) + (a * 30) - 2;
    }
    public String nullIfOddLength(String source){
        if (source.length() % 2 == 0){
            return source;
        }
        return null;
    }
}
