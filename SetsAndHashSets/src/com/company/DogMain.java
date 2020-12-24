package com.company;

public class DogMain {
    public static void main(String[] args) { // able to call this method
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)); // true b/c Labrador is an instance of dog but not
                                                    // not the other way around
        System.out.println(rover.equals(rover2)); // false, b/c we overrode equals method
        // ^^ now is true, b/c we took away the option to override the equals method of dog Class
    }
}
