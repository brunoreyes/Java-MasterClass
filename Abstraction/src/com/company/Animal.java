package com.company;

public abstract class Animal { //to make a class "abstract" add the key word in place of static
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    // it's best to leave breathe and eat as abstract methods as most animals can do this
    public abstract void eat();
    public abstract void breathe();

    public String getName() {
        return name;
    }

}
