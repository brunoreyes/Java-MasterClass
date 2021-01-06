package com.company;

// livelock is similar to a deadlock but instead of the threads being blocked they
// are all constantly active and usually waiting for other threads to complete their task.
// However, since all are waiting for others to complete, none of the threads can actually progress.

// For ex:
// Thread A will loop until thread B completes it's task.
// Thread B will loop until thread A completes it's task.
// Now the threads can get into a livelock state where both threads
// are looping and waiting for the other to complete it's task.

// A solution depends on the code, there's no one size fits all

// Apart from deadlocks and livelock the next problem that can occur with a multithreaded app
// is called a Slipped Condition (A specific type of race condition aka a thread interference).
// Which can occur when a thread can be suspended between reading a condition and acting on it.

// A slipped condition can be solved by using synchronized (occur at the same time or rate)
// blocks or locks to synchronize the critical section of the code. However if the code's already
// synchronized, then the placement of the synchronization may be the issue. When using multiple locks,
// the order in which the locks can be acquired can also result in a slipped condition

// When not synchronizing code properly:
// 1. Thread1 checks the status and gets OK. It suspends
// 2. Thread2 checks the status and gets OK. It reads EOF (end of file) from the buffer and sets
// the status of EOT, then terminates.
// 3. Thread1 runs again. It tries to read data from the buffer, but there isn't any. It throws
// an exception or crashes


public class Main {

    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();

    }
}
