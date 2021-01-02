package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// To define immutable objects:
// 1. Don't provide setters X
// 2. Make all fields private and final X
// 3. Don't allow subclasses to override methods X
// 4. If the instance fields include references to mutable objects, don't allow those objects to be changed X
// - removed addExits method that modified the map, changed getExits constructor that changed the map


public class Main {
    private static Locations locations = new Locations();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
// Instead of using hashmap this time around. I've placed a map interface within Class Locations
        Map<String, String> vocabulary = new HashMap<String, String>(); // <keyType, valueType>
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");

        int loc = 64; // introducing a new starting point giving me a complex junction
//        int loc = 1;
        while (true){ // while loc # exist
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            for (String exit: exits.keySet()){
                System.out.print(exit + ","); // mapping out exits
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase(); // making all user input the same case

            if (direction.length() > 1){ // // not a single-character command thus further processing required
                String[] words = direction.split(" ");
                for(String word: words){
                    if (vocabulary.containsKey(word)){ // if the user's input contains the same word in the vocab
                        direction = vocabulary.get(word); // then pass that word as the direction and ignore other words
                        break;
                    }
                }
            }else {

            }

            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }


//            loc = scanner.nextInt(); // loc changes as user changes loc value
//            if (!locations.containsKey(loc)){
//                System.out.println("You cannot go in that direction");
//            }
    }

//        Spit method example
//        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
//        for (String i : road) {
//            System.out.println(i);
//        }
//
//        System.out.println("==================================");
//
//        String[] building = "You are inside a building, a well house for a small spring".split(", ");
//        for (String i : building) { // for (key: value) loop
//            System.out.println(i);
//        }

    }
}
