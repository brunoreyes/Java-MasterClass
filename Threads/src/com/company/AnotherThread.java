package com.company;

public class AnotherThread extends Thread { // extending Thread class to override

    @Override
    public void run() {
        System.out.println("Hello from another thread");
    }


}
