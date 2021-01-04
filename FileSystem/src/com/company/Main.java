package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        try {
            // Deleting a file
            Path fileToDelete = FileSystems.getDefault().getPath(
                    "Examples","Dir1","file1copy.txt");
            Files.delete(fileToDelete);
            // good to use if you don't want an exception to be thrown if a file doesn't exist
//            Files.deleteIfExists(fileToDelete);

            // moving files to a new directory
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath(
//                    "Examples","Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);

            // renaming and moving a file into another directory
//            Path fileToMove2 = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination2 = FileSystems.getDefault().getPath(
//                    "Examples","Dir1", "file4.txt");
//            Files.move(fileToMove2, destination2);

//            // Since file1 exist, it's copied and stored within the directory Examples as file1copy
//            Path sourceFile = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
////            Files.copy(sourceFile, copyFile);
//
//            // avoid exception block from being executed
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e){
//            e.printStackTrace();
            System.out.println(e.getMessage()); // since we just created the file, this message gets called
        }

    }
//	    // path interface used to identify a file on a file system
//
//        // the character used to separate directory names in a path is called a delimiter (/) on Unix
//
//        // file paths can be absolute, relative. absolute paths start with a root node like C:\ or users
//        // otherwise the path is considered relative
//
//        // new directory is the same as new folder bc directory means folder
//
//        // OutThere one folder outside of project path
//        // Working Directory
//        // SubDirectory
//
//        // .getDefault is more convenient to get paths from within project directory
//        // creating a path and calling the print file method with the relative path in it
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
//        System.out.println(); // adding space
//
//        // passing a 2nd parameter files to get path within working project: files/file1.txt.txt
////        Path filePath = FileSystems.getDefault().getPath("files","file1.txt.txt");
//
////        .get(currentDirectory, file's directory (the subFolder), fileNameItself)
//        Path filePath = Paths.get(".", "files", "file1.txt.txt");
//        printFile(filePath);
//
//        System.out.println();
//
////        .get(currentDirectory, file's directory (the subFolder), fileNameItself)
//        // grabbing a file outside of project path's (specified the absolute path)
//        filePath = Paths.get("/Users/brunoreyes/Desktop/Code/Java/Java-MasterClass/OutThereFile.txt");
//
////        filePath = Paths.get("Users/brunoreyes/Desktop/Java","Java-MasterClass","OutThereFile.txt");
//
//        printFile(filePath);
//
//        // getting the absolute path of this project from the console
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(".", "files",
//                "..", "files", "file1.txt.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());
//        // generally a good idea to normalize a path when getting it from a user or another source.
//
////        java.IO.File, file class has issues b/c a lot of methods don't throw exceptions, leaving you
////        dumbfounded. No support for symbolic links.
//
////        File class cannot get metadata from a file and is inefficient.
//
////        Working through a directory tree is problematic.
//
//
//        // Java.io file class contains methods for pointing and deleting and others
//        // Now Java.nio the path interface sticks to file paths, leaving java operations
//        // moved to Java.nio.file.files class
//
//        // The files class contains copy, move and delete
//
//        // Checking whether a file or directory exist
//
//        /// path to file that doesn't exist
//        Path path3 = FileSystems.getDefault().getPath("ThisFileDoesNotExist.txt");
//        System.out.println(path3.toAbsolutePath());
//        //Output: /Users/brunoreyes/Desktop/Code/Java/Java-MasterClass/FileSystem/ThisFileDoesNotExist.txt
//
//        // creating a path that doesn't exist
//        Path path4 = Paths.get("/Volumes/Test/ING", "abcdef", "doesnNotExist.txt");
//        System.out.println(path4.toAbsolutePath());
//
//        // best to check and see if the path or file exist
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath)); // output: true
//
//        // testing to see if path 4 exist, should not exist
//        System.out.println("Exists = " + Files.exists(path4)); // output: false
//        System.out.println("Exists = " + Files.exists(path3)); // output: false
//
//    }
//
//    private static void printFile(Path path){
//        // read the contents of a file and prints it on the screen
//        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }

}
