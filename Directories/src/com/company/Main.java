package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class Main {
// To walk a file tree, I'll use the FileVisitor interface, running code at each stage
//    of the traversal process using the preVisitDirectory() (called before entries in dir are visited)
//    &  postVisitDirectory() (called after entries in dir are visited)
//    visitFile() skips files to go to a direct file
//    visitFileFailed() goes to files that can't be accessed

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

        // Creating directory path using file separator to get user's OS preference for file separator
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");

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

        // getting the file separator for the operating system a user is using to run your java code
        String separator = File.separator; // OS: / windows: \
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("myapp",".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        // getting location where file is stored
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store: stores) {
            System.out.println("Volume name/Drive letter = "+ store);
            System.out.println("File store = "+ store.name());
        }

        System.out.println("*************");

        // getting root directories
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path: rootPaths) {
            System.out.println(path);
        }

        System.out.println("--Walking Tree for Dir2--");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" +
                File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("--Copy Tree for Dir2--");
        Path copyPath = FileSystems.getDefault().getPath(
                "FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        // FileTree.Dir4.Dir2Copy
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        File file = new File("/Examples/file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("/Examples");
        File resolvedFile = new File(parent, "dir/file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("/Examples","dir/file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("/Examples");
        Path childRelativePath = Paths.get("dir/file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("--- print dr2 contents using list() ---");
        File dir2File = new File(workingDirectory, "/FileTree/Dir2");
        String[] dir2Contents = dir2File.list();
        for (int i = 0; i < dir2Contents.length; i++) {
            System.out.println("i = "+ i + ": " + dir2Contents[i]);
        }

        System.out.println("--- print dr2 contents using listFiles() ---");
        File[] dir2Files = dir2File.listFiles();
        for (int i = 0; i < dir2Files.length; i++) {
            System.out.println("i = "+ i + ": " + dir2Files[i].getName());
        }

        // * characters matches any string containing any # of characters
        // 8.dat matches any path with .dat extension
        // *.{dat,txt} matches any path that has .dat or .txt
        // ? matches any one char
        // myFile* matches any file that begins with myFile
        //b?*.txt matches any path with at least two chars long and begins w/ char b
    }
}
