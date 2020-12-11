package com.company;

// when using extend className we are able to use Animal's constructors
public class Dog extends Animal{
    // then get the constructor
    // code > generate > constructor


    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    // initialize base characteristics of animal in a constructor
    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        // super means to call the constructor from the class we are extending from (Animal)
        super(name, 1, 1, size, weight); // we know all dogs have brain and body
        this.eyes = eyes;
        this.legs = legs;
        this.teeth = teeth;
        this.coat = coat;
    }

    @Override // overriding this method from class: Animal via code > generate > override methods
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();

    }

    private void chew(){
        System.out.println("Dog.chew() called");
    }

    //how would a dog move?
    public void walk(){
        System.out.println("Dog.walk() called");
        move(3); // calling move from Class Animal
       // super.move(3); //this will find move from the inherited animal class
        // create a method with the same name that has the same implementation
    }
    public void run(){
        System.out.println("Dog.run() called");
        move(10);
    }
}
