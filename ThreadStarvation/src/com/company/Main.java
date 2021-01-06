package com.company;

// Recall when using synchronized blocks, it is not first come, first serve.

// When there is more than one thread waiting for a lock and that lock becomes
// available, the OS (Operating System) won't necessarily choose the thread that's
// been waiting the longest to run.

// A thread can block on the lock first but that doesn't mean it will be the thread to
// run when the lock is available.

// The OS may choose another thread if it has a higher priority
// than the first blocked thread.

public class Main {
    // Starting off by adding a static var to synchronize code
    private static Object lock = new Object();

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
                synchronized (lock){
                    System.out.format(threadColor +"%s: runCount = %d\n",// %s: parameter, %d: int parameter
                            Thread.currentThread().getName(),runCount++); // \n: newline
                    // execute critical section of code, creating a worker object for each thread
                }
            }
        }
    }

}
