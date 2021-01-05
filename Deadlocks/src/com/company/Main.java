package com.company;

// A deadlock occurs when 2 or more threads are blocked on locks and every thread that
// is blocked is holding a lock that another block thread wants.

// For example: Thread 1 is holding lock 1 and waiting to acquire lock 2,
// but thread 2 is holding lock 2 and is waiting to acquire lock 1,
// because all threads holding the locks are blocked. Never releasing the
// locks they are holding, so none of the waiting threads will ever run.

public class Main {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {

    }

    private static class Thread1 extends Thread {
        public void run(){
            // When thread1 runs it will try to obtain the lock for lock1
            synchronized (lock1){
                // If successful it will then go to sleep for 100 milliseconds
                // to give the second thread a chance to run
                System.out.println("Thread 1 has lock 1");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){

                }
                // When thread1 wakes it'll try to obtain the lock for the lock2 object
                System.out.println("Thread 1: Waiting for lock 2");
                synchronized (lock2){
                    System.out.println("Thread 1 has lock 1 & now lock 2");
                }
                System.out.println("Thread 1 has released lock 2 ");
            }
            System.out.println("Thread 1 has released lock 1. Exiting...");
        }
    }
    private static class Thread2 extends Thread {
        public void run(){
            synchronized (lock2){
                System.out.println("Thread 2 has lock 2");
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){

                }
                System.out.println("Thread 2: Waiting for lock 1");
                synchronized (lock2){
                    System.out.println("Thread 2 has lock 2 & now lock 1");
                }
                System.out.println("Thread 2 has released lock 1");
            }
            System.out.println("Thread 2 has released lock 2. Exiting...");
        }
    }
}


