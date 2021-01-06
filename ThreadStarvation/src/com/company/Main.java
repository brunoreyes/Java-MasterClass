package com.company;

// Recall when using synchronized blocks, it is not first come, first serve.

// When there is more than one thread waiting for a lock and that lock becomes
// available, the OS (Operating System) won't necessarily choose the thread that's
// been waiting the longest to run.

// A thread can block on the lock first but that doesn't mean it will be the thread to
// run when the lock is available.

// The OS may choose another thread if it has a higher priority
// than the first blocked thread.

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    // Starting off by adding a static var to synchronize code


    // by setting the instance of the ReentrantLock to true, I am stating that
    // I want it to be set up to be first come, first served order.

    // Fair reentrant locks only guarantee fairness in acquiring a lock not
    // fairness in thread scheduling.

    // The try lock method on the other hand, does not honor the fairness setting.
    // It is not first come, first served.

    // When using fair locks with a lot of threads, performance will be affected.
    // To ensure fairness, an additional layer of processing occurs, managing
    // which thread gets the lock, slowing things down with a lot of threads
    // competing for the lock.

    private static ReentrantLock lock = new ReentrantLock(true);
    // ensuring a far more fair result with plenty of interweaving threads,
    // eliminating the starvation problem



    //    private static Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        // Starvation describes a situation where a thread is unable to gain regular access to
        // shared resources and is unable to make progress. This happens when shared resources
        // are made unavailable for long periods by "greedy" threads. For example, suppose an
        // object provides a synchronized method that often takes a long time to return. If one
        // thread invokes this method frequently, other threads that also need frequent synchronized
        // access to the same object will often be blocked.

        // Since synchronized blocks aren't first come first served,
        // setting priority can result in starvation to happen . Threads can languish even
        // when a lock is frequently released.

        // The order I've started my threads isn't necessarily the order that the OS will run in.
        // Even though we suggested a certain order of priority to the OS.

        // A thread can only be suspended once in the middle of counting or not. In other words,
        // a thread can run for quite a long time while the other threads are stuck waiting.

        // So the thread with the highest priority hogged up all the time and then the other threads
        // didn't run in order of priority, but results vary. Priority has a loosely effect on order.

        // The reentrant lock implementation allows for the creation of fair locks

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Question: How will all threads block on the same lock object, since I am passing
        // the a different worker object to each thread?

        // Answer: The worker objects may be different but the lock on the object is static,
        // so in other words, there is only one instance of the object. Therefore all the threads
        // will be competing for that thread's one instances lock.



    }

    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor){
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
//                synchronized (lock){
                    lock.lock();
                    try {
                        System.out.format(threadColor +"%s: runCount = %d\n",// %s: parameter, %d: int parameter
                                Thread.currentThread().getName(),runCount++); // \n: newline
                    } finally {
                        lock.unlock();
                    }
                    //                }
            }
        }
    }

}
