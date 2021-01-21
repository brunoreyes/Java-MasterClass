package com.company;

import java.net.Socket;

// creating a socket for each client
public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket){
        this.socket = socket;
    }
}
