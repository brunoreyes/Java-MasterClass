package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        // Producer: Thread that adds data to a buffer
        // Consumer: Thread that reads data from the buffer

        List<String> buffer = new ArrayList<String>();

        // lock object, using instance of ReentrantLock class
        ReentrantLock bufferLock = new ReentrantLock();

        // ExecutorService handles thread pools, (multiple threads)
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // ExecutorService is overkill for this situation but optimal when dealing wil a lot of threads


        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock); // utilizing private packages
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_BLUE);
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get()); // future.get() blocks until the result is available
        } catch (ExecutionException e){
            System.out.println("Something went wrong");
        } catch (InterruptedException e){
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown(); // have to manually shutdown executorService
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }
    public void run(){
        Random random = new Random();
        String[] nums = {"1","2", "3", "4", "5"};
        for ( String num: nums){
            try {
                System.out.println(color + "Adding..." + num);
//                synchronized (buffer){
                bufferLock.lock(); // lock() acquires the lock
                // by adding a try and finally unlock only has to be in finally clause and will be executed
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock(); // unlock() releases the lock
                    // forgetting to release the lock, threads waiting for the lock
                    // will start blocking forever.
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF & exiting...");
        bufferLock.lock();
        try {
            // updating the array list
            buffer.add("EOF");// letting consumers know there won't be any more data to process.

        } finally {
            bufferLock.unlock();
        }
//        synchronized (buffer){
//        }
    }
}

class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;


    MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock){
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }
    public void run(){
        int counter = 0;

        while (true){
          //  synchronized (buffer){ // thread interference no longer occurs thanks to synchronized

            // tryLock() acquire the lock only if it isn't acquired by another thread
            if (bufferLock.tryLock()) { // so tryLock is bufferLock.lock(); if isn't acquire already
                try {
                    if (buffer.isEmpty()){
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;
                    if (buffer.get(0).equals(Main.EOF)){
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }

//        ReentrantLock lock1:
//        public void methodA(){
//            lock1.lock();
//            methodB();
//            [more code]
//        lock1.unlock();
//        }
//        public void methodB(){
//            [more code]
//            lock1.lock();
//            methodB();
//            [more code]
//            lock1.unlock(); // when methodB calls unlock we don't want any other threads to
        // get lock1 bc method A still expects to be holding the lock.

        // Bc the same thread can acquire the same lock multiple times, the unlock method won't
        // release the lock until the hold count reaches 0.
    }
}

// drawbacks for synchronized code:

// First drawback is that threads that are blocked
//waiting to execute synchronize code can't be interrupted
//once they're blocked their stuck there until they get the lock for the object
//the code is synchronizing on and if you think about it that can lead to
//problems.

// Second drawback is that the synchronized block must be within the same method in other
//words we can't start a synchronized block in one method and end the
//synchronization block in another for obvious reasons

//Third drawback is that we can't test to see if an object's intrinsic lock is
//available or find out any other information about that lock
//also if the lock isn't available we can't timeout after we waited for the
//lock for a while when we reach the beginning of a synchronized block
//we can either get the lock and continue executing or block at that line of code
//until we get the lock and the fourth drawback is that if multiple threads are
//waiting to get a lock