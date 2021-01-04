package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from the main thread");

        // Creating an instance of another thread class
        Thread anotherThread = new AnotherThread();
        anotherThread.start(); // enables the JVM to run the run() method from the thread
        // output:
        // Hello from the main thread
        // Hello from another thread

        System.out.println("Hello again from the main thread");
        // output: (never assume it'll run in the same order, up to the system to schedule when threads run)
        // Hello from the main thread
        // Hello again from the main thread
        // Hello from another thread

       // anotherThread.start(); // Not allowed to create a new instance of another thread more than once

        new Thread(){
            public void run(){ // Creating an anonymous class thread
                System.out.println("Hello from the anonymous class thread");
            }
        }.start();
    }
}
