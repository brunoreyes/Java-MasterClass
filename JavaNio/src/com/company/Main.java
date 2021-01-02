package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    // Previously I gave Java.nio classes the ability to create commonly used Java.io streams.
    // Doing I/O using Java.nio means that data is processed in blocks rather than one byte
    //  or character at a time. Java.nio uses channels and buffers and also sometimes selectors.

    // Channel is the DataSource you're reading from or writing to.
    // That can be a file or socket or any other DataSource.

    // To use a DataSource as a channel, you need a class that implements
    // the Java.nio.channel interface and can connect to the DataSource.

    // A Buffer, on the other hand, is the container for the block of data
    // that you want to read or write.
    // Buffers are typed and that means that they can only hold one type of data.
    // You can actually specify the size of the buffer as well.

    // Selectors allow a single thread to manage the I/O for multiple channels.
    // Generally only needed in large enterprise applications

    // With Java.nio we only need one instance of a channel to both read and write from the same data
    // source. Also reading and writing is buffered, no longer having to wrap read/write in buffered instances
    // like the case of java I/O.

//    Java.nio is often a lot slower than a java.io when it comes to larger files
//    Java.nio is better for large apps that use multiple threads to do io.

    public static void main(String[] args) {
        try {
//            // Creating the file input stream
//            FileInputStream file = new FileInputStream("data.txt");

//            // Calling the getChannel method to get the file channel
//            FileChannel channel = file.getChannel();

            Path dataPath = FileSystems.getDefault().getPath("data.txt");

            // Writing bytes, converting a string to bytes in the data.txt file.
            // StandardOpenOption.APPEND to write more to a file that already exist
            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);

            List<String> lines = Files.readAllLines(dataPath); // calling the file's readAllLines method
            for (String line : lines){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
