package com.company;

import java.io.*;
import java.nio.ByteBuffer;
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
        try(FileOutputStream binaryFile = new FileOutputStream("data.dat");
            FileChannel binaryChannel = binaryFile.getChannel()) {

            // Buffer's capacity is the number of elements it can contain

            // Buffer's position is the index of the next element that should be read/written
            // and it cannot be greater than the buffer's capacity

            // Buffer's mark is used by the buffer dot reset method, when called, the buffer's
            // position is reset to it's mark.

            // To rewind the buffer to a certain point, you'll mark the point, and then later you
            // can call the reset method to reset the position of the mark.

            // Mantra for fixing errors in java.NIO: when something goes wrong, flip

            ByteBuffer buffer = ByteBuffer.allocate(100);

            // chained version of method calls
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000); // chained method calls
//            buffer.flip();

//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

            // Unchained long method calls
            // all writes are relative writes, (not specifying index like absolutes)
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245); // wrote first integer, with start position being the number of bytes in the string

            long int2Pos = int1Pos + Integer.BYTES; // defining start position for next int is length of string + int of integer
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length; // 3rd start position of second int + size of int + size of second String
            buffer.putInt(1000);
            buffer.flip(); // flip from writing to reading to the buffer
            binaryChannel.write(buffer); // writing buffer's contents to the binary file channel

            RandomAccessFile ra = new RandomAccessFile("data.dat","rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer); // read methods reads until the end of the file
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());

            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());


            // Creating a byte array for the string I want to output
//            byte[] outputBytes = "Hello World!".getBytes(); // 12 bytes were written

            // wrapping the byte array into a buffer, modifying the array/buffer changes the buffer/array.
//            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            // when calling wrap(), you tell the run time that you want to use the byte array as the buffer

//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//
//
//            buffer.flip();
//            int numBytes = binaryChannel.write(buffer); // using channel to write
//            System.out.println("numBytes written was: " + numBytes);
//
//            // Calling ByteBuffer.allocate() and passing the size we want the buffer to be an Int value
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip(); // sets the buffers position back to zero
//            numBytes = binaryChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765); //
//            intBuffer.flip(); //always recall to set position of buffer back to 0 using the flip method
//            numBytes = binaryChannel.write(intBuffer); // starting read at the buffer's position (245)
//                                                        // not starting position is 0
//            System.out.println("numBytes was written as " + numBytes); //  0 bytes were written
//
//
////            // Creating the file input stream
////            FileInputStream file = new FileInputStream("data.txt");
//
////            // Calling the getChannel method to get the file channel
////            FileChannel channel = file.getChannel();
//
////            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//
//            // Writing bytes, converting a string to bytes in the data.txt file.
//            // StandardOpenOption.APPEND to write more to a file that already exist
////            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
////
////            List<String> lines = Files.readAllLines(dataPath); // calling the file's readAllLines method
////            for (String line : lines){
////                System.out.println(line);
////            }
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            // changes outputBytes variable to abllo World!, read method isn't returning expectedly
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip(); // always remember to call flip
//            // now the read method returns  Hello World!
//
//            long numBytesRead = channel.read(buffer);
//
//            if (buffer.hasArray()){
//                System.out.println("byte buffer = " + new String(buffer.array()));
////                System.out.println("byte buffer = " + new String(outputBytes));
//            }
////      Absolute Read, allowing us to forgo using the flip method for the buffer after reading from
////            the file channel. When using absolute, the buffer position isn't updated
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//
//            intBuffer.flip();
//
//            // absolute read, specifying the index
//            System.out.println(intBuffer.getInt(0));
//
//            // relative read bc absolute read above doesn't change position
//            System.out.println(intBuffer.getInt());

//      Relative Read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            channel.close();
//            ra.close();

//            System.out.println("outputBytes = " + new String(outputBytes));

//            // retrieving data via RandomAccessFile Class
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputByte.length];
//            ra.read(b); // what is read goes into the byte array
//            System.out.println(new String(b));
//
//            // reading in the two integers
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
