package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost(); // getByName()
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String echString;

            do {
                System.out.println("Enter string to be echoed: ");
                echString = scanner.nextLine();

                byte[] buffer = echString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is " + new String(buffer2, 0, packet.getLength()));

                // client is set up to await for a response but not necessarily the case in all real-world scenarios

            } while (!echString.equals("exit"));

        } catch (SocketTimeoutException e){
            System.out.println("Socket timed out");
        } catch (IOException e){
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

