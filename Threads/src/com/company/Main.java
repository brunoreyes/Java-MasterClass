package com.company;

import static com.company.ThreadColor.ANSI_GREEN;
import static com.company.ThreadColor.ANSI_PURPLE;


public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE +"Hello from the main thread");

        // Creating an instance of another thread class
        Thread anotherThread = new AnotherThread();
        anotherThread.start(); // enables the JVM to run the run() method from the thread
        // output:
        // Hello from the main thread
        // Hello from another thread

        // anotherThread.start(); // Not allowed to create a new instance of another thread more than once

        new Thread(){ // Creating an anonymous class thread, since running in background it ran last
            // but that could change
            public void run(){
                System.out.println(ANSI_GREEN +"Hello from the anonymous class thread");
            }
        }.start();

        System.out.println( ANSI_PURPLE +"Hello again from the main thread");
        // output: (never assume it'll run in the same order, up to the system to schedule when threads run)
        // Hello from the main thread
        // Hello again from the main thread
        // Hello from another thread


    }
}
