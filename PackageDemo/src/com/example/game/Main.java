package com.example.game; // package format has to match breadcrumbs

import com.example.game.ISavable;
import com.example.game.Monster;

import java.util.ArrayList;
import java.util.Scanner;

// JAR stands for Java Artifact
public class Main {

    public static void main(String[] args) {
	// when adding classes to your package from other packages, make sure to copy & paste and
        // do not directly move the package

            com.example.game.Player bruno = new com.example.game.Player("Bruno", 12, 16);
            System.out.println(bruno.toString()); // all elements will show up with correspond values
            saveObject(bruno);

            bruno.setHitPoints(8);
            System.out.println(bruno);
            bruno.setWeapon("StormBringer");
            saveObject(bruno);
//        loadObject(bruno);
            System.out.println(bruno);

            ISavable werewolf = new Monster("Werewolf",20,40);
            System.out.println("Strength = " + ((Monster) werewolf).getStrength()); // casting
            System.out.println(werewolf);
            saveObject(werewolf);
        }
        public static ArrayList<String> readValues() {
            ArrayList<String> values = new ArrayList<String>();

            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            int index = 0;
            System.out.println("Choose\n" +
                    "1 to enter a string\n" +
                    "0 to quit");

            while (!quit) {
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        System.out.print("Enter a string: ");
                        String stringInput = scanner.nextLine();
                        values.add(index, stringInput);
                        index++;
                        break;
                }
            }
            return values;
        }

        public static void saveObject(ISavable objectToSave){
            for (int i = 0; i < objectToSave.write().size(); i++){
                System.out.println("Saving "+ objectToSave.write().get(i)+ " to storage device");
            }
        }
        public static void loadObject(ISavable objectToLoad){
            ArrayList<String> values = readValues();
            objectToLoad.read(values);
        }
    }

