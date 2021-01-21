package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


	// Starting to write the method similar to ServerSocket, but instead creating a Socket
        try(Socket socket = new Socket("localhost", 5000)) {
                                        // host: the address of the host I want to connect to
                                        // if "localhost" doesn't work, use "127.0.0.1" which is
                                        // an ip address that results to this computer as well

                                        // the port number should be within the documentation or server
            socket.setSoTimeout(5000);
            // the socket timed out, preventing a client from blocking forever
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;
            // Using a do while loop to at least ensure the loop executes once
            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")){
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));
        }catch (SocketTimeoutException e){
            System.out.println("The socket timed out");

        } catch (IOException e){
            System.out.println("Client Error: " + e.getMessage());
        }
    }
    // Successfully wrote my first client and server, establishing and terminating a connection
}
