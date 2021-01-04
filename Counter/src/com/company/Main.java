package com.company;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {

    private int i;

    public void doCountdown() {
        String color; // String variables are reused
        // do not use local vars to synchronize a full stop

        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        synchronized (this) { // the threads no longer interweave or skip numbers
            // static methods and objects can be synchronized as well

            // synchronization is reentrant meaning if a thread acquires an objects lock
            // and within the synchronized code it calls a method that uses the same object to
            // synchronize some code. The thread can acquire a lock it already owns.

            // When a class or method is thread-safe t means the dev has synchronized all
            // the critical sections within the code, so I don't have to worry about the
            // thread interference

            // None of the UI components are safe in JavaFX, so JavaFX allows all code to run
            // on JavaFX run-time thread

            // When synchronizing code, only synchronize what's necessary like the for loop here

            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}
