package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    // produce and consume messages

        // issue is once one of the threads start looping the other one can't change the value of empty
        // because the thread is blocked. Only one synchronized method can run at a time.
        // So the thread that is looping is holding the lock for the message object, and the other one is blocked,
        // waiting for the other thread to release the lock. This situation is called a deadlock.
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message{
    private String message;
    private boolean empty = true;

    public synchronized String read(){
        while (empty){
            try {
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        while (!empty){
            try {
                wait(); // call wait within a loop so when it returns, we'll go back to the beginning of the loop
                // never assume a thread has been woken up because the condition that's waited on will be changed.

                // Now each Thread now waits and releases it's lock on the message object when the loop condition
                // passes, giving the other thread the opportunity to run.

                // Now able to process the message and change the value of the empty var. When it calls the notifierAll
                // method, the thread that is waiting is now able to proceed. The two thread go back and forth like this
                // until all the messages have been printed.

                // Atomic operations in Java that happen all at once, and a thread can't be suspended in the middle of them.
                // Atomic operations: reading & writing reference variables, primitive var except Long and doubles

                // Array list is not thread safe

            } catch (InterruptedException e){

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}
class Writer implements Runnable {
    private Message message;
    public Writer(Message message){
        this.message = message;
    }
    public void run(){
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the kings horses and all the kings men",
                "Couldn't put Humpty together again"
        };
        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try { // sleeping for 2 secs after writing a message
                Thread.sleep(random.nextInt(2000)); // generating a random delay
            } catch (InterruptedException e){

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message){
        this.message = message;
    }
    public void run(){
        Random random = new Random();
        // looping through the messages received, searching for the last message which is Finished
        for (String latestMessage = message.read(); !latestMessage.equals("Finished") ;
             latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
    }
}
