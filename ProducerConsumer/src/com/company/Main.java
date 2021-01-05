package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        // Producer: Thread that adds data to a buffer
        // Consumer: Thread that reads data from the buffer

        List<String> buffer = new ArrayList<String>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN); // utilizing private packages
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }
    public void run(){
        Random random = new Random();
        String[] nums = {"1","2", "3", "4", "5"};
        for ( String num: nums){
            try {
                System.out.println(color + "Adding...");
                synchronized (buffer){
                    buffer.add(num);
                }


                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF & exiting...");
        synchronized (buffer){
            buffer.add("EOF");// letting consumers know there won't be any more data to process.
        }
    }
}

class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;

    MyConsumer(List<String> buffer, String color){
        this.buffer = buffer;
        this.color = color;
    }
    public void run(){
        while (true){
            synchronized (buffer){ // thread interference no longer occurs thanks to synchronized

                if (buffer.isEmpty()){
                    continue;
                }
                if (buffer.get(0).equals(Main.EOF)){
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }

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
}