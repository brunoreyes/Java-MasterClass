package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

// LinkList is great for inserting massive amounts of data
public class Demo {
    public static void main(String[] args) { // shortcut: psvm generates a main method outside of Class Main
        LinkedList<String> placesTovVisit = new LinkedList<String>();
        // Alphabetized list utilizing addInOrder(list,"elementName);
        addInOrder(placesTovVisit,"Mexico");
        addInOrder(placesTovVisit,"Spain");
        addInOrder(placesTovVisit,"England");
        addInOrder(placesTovVisit,"London");
        addInOrder(placesTovVisit,"Korea");
        addInOrder(placesTovVisit,"Japan");
        printList(placesTovVisit);

        addInOrder(placesTovVisit,"New Zealand");
        addInOrder(placesTovVisit,"Belize");
        addInOrder(placesTovVisit,"New Zealand"); // checking to see if duplicate isn't added and message appears
        printList(placesTovVisit);
        visit(placesTovVisit);


// Previous version (un-alphabetizing list)
//        placesTovVisit.add("Mexico"); //Now visiting Mexico
//        placesTovVisit.add("Spain");
//        placesTovVisit.add("England");
//        placesTovVisit.add("London");
//        placesTovVisit.add("Korea");
//        placesTovVisit.add("Japan");
//        printList(placesTovVisit);
//
//        placesTovVisit.add(1, "Belize"); // placing Belize in Spain's index and moving Spain's index down
//        printList(placesTovVisit);
//
//        placesTovVisit.remove(4); // should remove London and Korea will take its place
//        printList(placesTovVisit);
        // Final Output:
        //        Now visiting Belize
        //        Now visiting Spain
        //        Now visiting England
        //        Now visiting Korea
        //        Now visiting Japan


        // Now we are going to create a linkedList and have it work in alphabetical order
        // 3 options to get this LinkedList in order
        // ignore duplicate countries
        // if it sorts alphabetically before the first city, then I'll instert it before the current city
        // if alphabetically it's greater than the current city, we will move it to the next city
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i= linkedList.iterator();
        // doing equivalent of a for loop
        while (i.hasNext()){ // i.e while an element in linkedList points to an element that comes after it,
                            // then we will show the  current record. // .hasNext() returns if there is or isn't a next element

            System.out.println("Now visiting " + i.next()); // .next() returns the new element & moves the next element down an index // i++
        }System.out.println("===========================");
    }

    public static boolean addInOrder(LinkedList<String> linkedList, String newCountry){
        ListIterator<String> stringListIterator = linkedList.listIterator(); // taking a list iterator and pointing it to

        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCountry); // .compareTo() returns a #, if 0 it's a match
                                            // .next(), for the first iteration goes to the first country in the list

            if (comparison == 0){
                // 0 means they are equal, the same
                System.out.println(newCountry + " is already included as a destination");
                return false;
            } else if (comparison > 0){  // .compareTo() returns a # > 0 so we move the current element downwards and make newCountry the current index

                // the new Country should appear before this one
                // Brisbane < Adelaide

                stringListIterator.previous(); // have to go back to previous element linked to this one
                                                // since variable comparison moved on to the next element

                stringListIterator.add(newCountry); // adding back at the previous point so new country appears before that element
                return true;

            } else if (comparison < 0){ // move on to next country (already done with comparison's .next()
            }
        } // so if newCountry doesn't come before a current country, or is the current country, then it'll be added to list's end
        stringListIterator.add(newCountry);
        return true;
    }

    private static void visit(LinkedList countries){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = countries.listIterator();

        if(countries.isEmpty()){ // .isEmpty() checks if an input is empty
            System.out.println("No countries in the itinerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;

                case 1:
                    if(!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    } else { System.out.println("We are at the start of the list");}
                    goingForward = true;
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    private  static void printMenu(){
        System.out.println("Available actions");
        System.out.println("0 - to quit\n" +
                        "1 - go to next country\n" +
                        "2 - go to previous country\n" +
                        "3 - print menu options");
    }
}
