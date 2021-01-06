package com.company;

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

        // Lambda Expression has 3 parts: argument list >> arrow token >> body
        new Thread(()-> System.out.println("Printing from the Runnable")).start();
    }
}
//class CodeToRun implements Runnable{
//    @Override
//    public void run(){
//        System.out.println("Printing from the Runnable");
//    }
//}
