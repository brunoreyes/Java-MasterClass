package com.company;


// Difference between using an abstract class and an interface
// relationship "is a" dog, phone, place - inherit from an abstract class
// relationship "has ability to " fly, take pictures underwater, use 5G - utilize interfaces

// An abstract class can have member variables that can be inheritied.

// Now Interfaces can have variables, but they'll be public static final variables that are constant values
// that won't change with a static scope. Interfaces can't be instantiated (using new to create instance of it) or
// have a constructors but abstract classes can.

// All methods of an interface are public while abstract classes can have any type of visibility.
// Abstract classes can have defined methods ( methods with an implementation).

// All methods in an interface are abstract, and there's no code in an abstract method. The code's written
// in the class that implements the particular interface

// Since abstract Animal Class implemented the get name method, all other classes that inherit from Animal don't need to
// reproduced that method

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorke");
        dog.breathe();
        dog.eat();
//        Bird bird = new Bird("Parakeet"); // cannot directly instantiate an abstract class
        Parrot parrot = new Parrot("Red Parrot"); // cannot directly instantiate an abstract class
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor"); // cannot directly instantiate an abstract class
        penguin.breathe();
        penguin.eat();
        penguin.fly();
    }
}
