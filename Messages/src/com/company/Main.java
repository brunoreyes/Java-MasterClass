package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    // produce and consume messages
    }
}

class Message{
    private String message;
    private boolean empty = true;

    public synchronized String read(){
        while (empty){

        }
        empty = true;
        return message;
    }

    public synchronized void write(String message){
        while (!empty){

        }
        empty = false;
        this.message = message;
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
