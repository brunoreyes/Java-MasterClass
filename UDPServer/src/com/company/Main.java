package com.company;

// UDP (User Datagram Protocol) requires some handshaking
// between the server and client. The client has to connect
// to the server, and the server has to accept that connection
// The client sends a request and the server sends a response

// UDP shouldn't be utilized if you require a response
// UPD uses datagrams, self-contained message, not guaranteed to
// arrive at its destination. UDP is often used with time-sensitive
// communication and when losing the odd message or packet here
// and there won't matter. For example: voice over ip apps like
// Skype uses UDP bc speed is more important than ensuring absolutely
// every packet arrives

// Overhead involved using TCP is much more significant

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) {
	    try {
            DatagramSocket socket = new DatagramSocket(5000);

            while (true){
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // blocks until the packet is received
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));
            }

        } catch (SocketException e){
            System.out.println("SocketException " + e.getMessage());
        } catch (IOException e){
            System.out.println("IOException " +  e.getMessage());
        }
    }
}
