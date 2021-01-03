package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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



            // Creating a byte array for the string I want to output
            byte[] outputBytes = "Hello World!".getBytes(); // 12 bytes were written

            // wrapping the byte array into a buffer, modifying the array/buffer changes the buffer/array.
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            // when calling wrap(), you tell the run time that you want to use the byte array as the buffer

            int numBytes = binaryChannel.write(buffer); // using channel to write
            System.out.println("numBytes written was: " + numBytes);

            // Calling ByteBuffer.allocate() and passing the size we want the buffer to be an Int value
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip(); // sets the buffers position back to zero
            numBytes = binaryChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765); //
            intBuffer.flip(); //always recall to set position of buffer back to 0 using the flip method
            numBytes = binaryChannel.write(intBuffer); // starting read at the buffer's position (245)
                                                        // not starting position is 0
            System.out.println("numBytes was written as " + numBytes); //  0 bytes were written


//            // Creating the file input stream
//            FileInputStream file = new FileInputStream("data.txt");

//            // Calling the getChannel method to get the file channel
//            FileChannel channel = file.getChannel();

//            Path dataPath = FileSystems.getDefault().getPath("data.txt");

            // Writing bytes, converting a string to bytes in the data.txt file.
            // StandardOpenOption.APPEND to write more to a file that already exist
//            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
//
//            List<String> lines = Files.readAllLines(dataPath); // calling the file's readAllLines method
//            for (String line : lines){
//                System.out.println(line);
//            }
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            // changes outputBytes variable to abllo World!, read method isn't returning expectedly
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip(); // always remember to call flip
            // now the read method returns  Hello World!

            long numBytesRead = channel.read(buffer);

            if (buffer.hasArray()){
                System.out.println("byte buffer = " + new String(buffer.array()));
            }
//      Absolute Read, allowing us to forgo using the flip method for the buffer after reading from
//            the file channel
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));

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
