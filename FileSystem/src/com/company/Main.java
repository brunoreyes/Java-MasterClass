package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	    // path interface used to identify a file on a file system

        // the character used to separate directory names in a path is called a delimiter (/) on Unix

        // file paths can be absolute, relative. absolute paths start with a root node like C:\ or users
        // otherwise the path is considered relative

        // new directory is the same as new folder bc directory means folder

        // OutThere one folder outside of project path
        // Working Directory
        // SubDirectory

        // .getDefault is more convenient to get paths from within project directory
        // creating a path and calling the print file method with the relative path in it
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        System.out.println(); // adding space

        // passing a 2nd parameter files to get path within working project: files/SubDirectoryFile.txt
//        Path filePath = FileSystems.getDefault().getPath("files","SubDirectoryFile.txt");

//        .get(currentDirectory, file's directory (the subFolder), fileNameItself)
        Path filePath = Paths.get(".", "files", "SubDirectoryFile.txt");
        printFile(filePath);

        System.out.println();

//        .get(currentDirectory, file's directory (the subFolder), fileNameItself)
        // grabbing a file outside of project path's (specified the absolute path)
        filePath = Paths.get("/Users/brunoreyes/Desktop/Code/Java/Java-MasterClass/OutThereFile.txt");

//        filePath = Paths.get("Users/brunoreyes/Desktop/Java","Java-MasterClass","OutThereFile.txt");

        printFile(filePath);

        // getting the absolute path of this project from the console
        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());
    }

    private static void printFile(Path path){
        // read the contents of a file and prints it on the screen
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
