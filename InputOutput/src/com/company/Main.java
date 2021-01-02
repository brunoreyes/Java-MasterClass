package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();
    public static void main(String[] args) {

//        A java byte stream can itself be used to read/write any of the primitive types and String variables,
//        eliminating the need for parsing

//        Object input/output steam classes can read and write objects as a single unit.
//        When writing an object to a file, it has to be translated to a format that can be stored to a file
//        and reassembled into an object later when read by an application.

//        The process of translating a data structure or an object into a format that can be stored and recreated
//        is called Serialization. This can be done by using a serialization interface, having no methods.
//        When creating a serialized class, it's best practice to create a private long field called SerialVersionUId
//        Serialization can work with LinkedHashMap as well b/c it implements the serialized interface


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
