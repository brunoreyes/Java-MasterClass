package com.company;

// livelock is similar to a deadlock but instead of the threads being blocked they
// are all constantly active and usually waiting for other threads to complete their task.
// However, since all are waiting for others to complete, none of the threads can actually progress.
// For ex:
// Thread A will loop until thread B completes it's task.
// Thread B will loop until thread A completes it's task.
// Now the threads can get into a livelock state where both threads
// are looping and waiting for the other to complete it's task.

public class Main {

    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

    }
}
