package com.company;

import java.util.HashMap;
import java.util.Map;

// A java map cannot contain duplicate keys and keys can only map to a single value
// map is generic and can take two types: one for the key and one for the value
public class MapExample { // cannot use map b/c key word

    public static void main(String[] args) { // shortcut: psvm
        Map<String, String> languages = new HashMap<>(); // Map <key, value> varName = new typeOfMay

        // .put(key, value) associates the key with the value, so when calling key (.get(key)), you get the key's value
        languages.put("Java", "compiled high level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All Purpose Symbolic Instruction Code");

        // .put() method can be used to tell if there is a value for a specific key
        System.out.println(languages.put("Lisp", "Therein lies madness"));
        // returns null, meaning it's a brand new reference
        System.out.println(languages.put("Lisp", "Therein lies madness"));
        // since first .put() of this key was processed, now the output is the proper value: "Therein lies madness"


        if(languages.containsKey("Java")){ // .containsKey() returns a boolean if a key exist within a map
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        // map values are unique and if you have a key and add a key with the same name, it's value will be overwritten
        languages.put("Java", "this course is about Java"); // this will overwrite the value of key: Java
        // so instead of value being "compiled high level..", it's "Java", "this course is about Java"

        System.out.println(languages.get("Java")); // .get(key) returns the value of the key

        System.out.println("=====================================");

        for (String key: languages.keySet()){ // for loop
            System.out.println(key + " : " + languages.get(key)); // no guaranteed order with a hashmap
        }


    }
}
