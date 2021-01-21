package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// Starting to write the method similar to ServerSocket, but instead creating a Socket


        try(Socket socket = new Socket("localhost", 5000)) {
                                        // host: the address of the host I want to connect to
                                        // if "localhost" doesn't work, use "127.0.0.1" which is
                                        // an ip address that results to this computer as well

                                        // the port number should be within the documentation or server

            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;




            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();
            }
        } catch (IOException e){
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
