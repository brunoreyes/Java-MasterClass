package com.company;

public class SomeClass {
    //private final int instanceNumber = 1; // since marked final, value cannot change
    public final int instanceNumber;
    private static int classCounter = 0;
    private final String name;


    public SomeClass(String name){
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
