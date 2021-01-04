package com.company;

import static com.company.ThreadColor.*;


public class Main {
    // To create a thread I can use the Thread or Runnable interface.

    // Most of the time it's more convenient to use the Runnable interface because there
    // are many methods in the Java API that want a runnable interface. Since Lambda,
    // runnable is also picked because it's more flexible.


    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE +"Hello from the main thread");

        // Creating an instance of another thread class
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start(); // enables the JVM to run the run() method from the thread
        //  anotherThread.run(); common mistake, don't call run() directly, call start() instead.
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

        // To run a runnable thread I create an instance of the thread class and pass an
        // instance of my runnable class to the thread constructor
//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.start();

        // Having an anonymous class implement runnable, passing an instance to the thread constructor
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class implementation of run()");
                try {
//                    anotherThread.join();  // join() waits for anotherThread to terminate

                    // wait for the termination or for time time out period to end, whichever happens first
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out," +
                            " so I'm running again");
                } catch (InterruptedException e){
                    // can't guarantee anything: which orders threads will execute or
                    // how long threads sleep or wake
                    System.out.println(ANSI_RED + "I couldn't wait after all, I was interrupted");
                }
            }
        });
        myRunnableThread.start();

        // Calling interrupt() instance
//        anotherThread.interrupt();


        System.out.println( ANSI_PURPLE +"Hello again from the main thread");
        // output: (never assume it'll run in the same order, up to the system to schedule when threads run)
        // Hello from the main thread
        // Hello again from the main thread
        // Hello from another thread



    }
}
