package com.company;
import static com.company.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread { // extending Thread class to override

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());
        try {
            Thread.sleep(3000); // never guaranteed sleep because thread could be interrupted
            // I interrupt a thread when I want it to terminate
            // for instance, searching for something else when I've already started a search

        } catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
        }
        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
    }





}
