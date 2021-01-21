package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// creating a socket for each client
public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true){
                String echoString = input.readLine();
                System.out.println("Received client input " + echoString);
                if (echoString.equals("exit")){
                    break;
                }
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e){
                    System.out.println("Thread interrupted");
                }

                output.println(echoString);
            }

        } catch (IOException e){
            System.out.println("Oops: " +  e.getMessage());
        } finally {
            try {
                // the break point has been hit, confirming the code is being executed on
                // the server side to close the socket when the client has issued.
                socket.close();
            } catch (IOException e){
                System.out.println("Oops: " +  e.getMessage());
            }
        }
    }


}
