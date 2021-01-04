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
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);
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
                buffer.add(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF & exiting...");
        buffer.add("EOF");// letting consumers know there won't be any more data to process.
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