package com.company;

public class StaticTest {
    private static int numInstances = 0; // static allows only one var numInstances to exist at any given time

    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++; // everytime numInstances is being used we increment
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
}
