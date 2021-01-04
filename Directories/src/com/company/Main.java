package com.company;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

// Lambda Expression of filtering a path
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        // filtering a path for a file
//        DirectoryStream.Filter<Path> filter =
//            new DirectoryStream.Filter<Path>(){
//                public boolean accept(Path path) throws IOException {
//                    return (Files.isRegularFile(path));
//                }
//        };

        // Creating directory path
        Path directory = FileSystems.getDefault().getPath("FileTree/Dir2");

        // Creating the directory's steam and returning a stream of paths
//        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory)) {

//        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,
//                "*.dat")) { // finding specific file with .dat extension

        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory,
                filter)) { // checking to see if (Files.isRegularFile(path));
            for ( Path file: contents
                 ) {
                System.out.println(file.getFileName()); // Dir3
            } // pipe character | is a byte wise inclusive "or"
        } catch (IOException | DirectoryIteratorException e){
            System.out.println(e.getMessage());
        }

        // * characters matches any string containing any # of characters
        // 8.dat matches any path with .dat extension
        // *.{dat,txt} matches any path that has .dat or .txt
        // ? matches any one char
        // myFile* matches any file that begins with myFile
        //b?*.txt matches any path with at least two chars long and begins w/ char b
    }
}
