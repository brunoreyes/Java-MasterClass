package com.company;

public class Main {

    public static void main(String[] args) {
	    // A Network is a system of computers connected together so they can share resources and communicate
        // with each other. Networking refers to how the connected computers communicate.

        // Networking in Java involves threads and input/output streams

        // Networking began in the private network, the Intranets, single businesses have multiple Intranets

        // A common network configuration is the client/server relationship, where 1 (or more) hosts on a network
        // act as servers, and the other hosts are client that connect to the server.
        // At a high level, this is how the Internet operates.

        // The browser is the client, it connects to the server that has the files for the website at that address.
        // This is oversimplified but is essentially how the internet works

        // Now client/server interactions can be preformed on the same host. For ex, MySQL DB comes with a workbench,
        // which can be used to preform DB operations. In this scenario, the workbench is the client connecting
        // to the MySQL database server.

        // Another example is local web development. It's possible to run an apache or IIS server on your computer
        // and connect to it using a browser on your computer.

        // Computers on a network (which includes the Internet) communicate with each other using a transport protocol,
        // here I'll be using the TCP & UCP protocols

        // Generally a computer will have 1 physical connection to a network, and anything sent to the computer from
        // other hosts on the network will arrive through that connection. But sometimes the same computer will be
        // running multiple apps that want data from the network. For ex, opening a browser, chat app & streaming music.

        // When data arrives at the one physical location to the network, it gets routed in via a port.
        // Each app that needs data from the network is assigned a port (including client's connections to a server
        // that is on the same machine). When the data arrives, the port # is used to route data to the app waiting for it.

        // IP stands for Internet Protocol

        // For client/server relationships, you'll often want a reliable, two-way communication link between
        // client and server. This is where the TCP (Transmission Control Protocol) comes in. The TCP establishes a
        // two-way connection between hosts. Here reliability refers to the two host being able to talk to each other.
        // When used with Internet addresses, you get TCP/IP which uses the client/server model

        // When communicating using TCP/IP, the sequence of events is as follows:
        //  1. The client opens a connection to the server
        //  2. The client sends a request to the server
        //  3. The client sends a response to the client
        //  4. The client closes the connection to the server
        // Steps 2 & 3 may be repeated multiple times before the connection is closed.

        // When using the low-level networking API, sockets will be used to establish connections, send request,
        // and receive responses. A socket is 1 endpoint of the 2-way connection. Client & server will both have a socket.

        // When you have multiple clients connecting to the same server, they'll use the same port number, but each
        // client will have its own socket.

        // Socket class for the client socket
        // ServerSocket class for the server's socket

        // With Java essentially all that has to be provided is the IP address and port # when creating a socket.
        // Underneath the covers, specific messages are sent to establish a connection between client & server,
        // the process is called handshaking. Data is sent as packets that have to be a specific format.
    }
}
