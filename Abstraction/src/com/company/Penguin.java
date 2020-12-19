package com.company;

public class Penguin extends Bird{
    public Penguin(String name) {
        super(name);
    }

    @Override // specific functionality for penguin class
    public void fly() {
        super.fly(); // overwriting the message for penguins flying
        System.out.println("I'm not very good at that, can I go for a swim instead?");
    }
}
