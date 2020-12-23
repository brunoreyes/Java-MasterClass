package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer,Location>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        // Creating a HashMap ( doesn't keep track of order but gives each mapped item a unique key) of vocab
        // a user can input

        Map<String, String> vocabulary = new HashMap<String, String>(); // <keyType, valueType>
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");

        int loc = 1;
        while (true){ // while loc # exist
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            for (String exit: exits.keySet()){
                System.out.print(exit + ", "); // mapping out exits
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
