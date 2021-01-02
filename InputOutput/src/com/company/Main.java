package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    public static void main(String[] args) {

//        A java byte stream can itself be used to read/write any of the primitive types and String variables,
//        eliminating the need for parsing

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
        }
    }
}
