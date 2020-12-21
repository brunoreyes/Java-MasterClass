package com.company;


import org.w3c.dom.Node;


public class Main {

    public static void main(String[] args) {
        // There are over 9 million Java developers, Class and Interface naming conflicts are inevitable

        // Mechanism is needed to fully specify class & it allows the use of classes with the same name
        //  in the same project ( or even the same class)

        // A Package is used as a way of grouping classes and interfaces together
        // helping programmers to know which classes that are related to another
        // a package creates a new namespace, class and interface name conflicts are avoided

//        javafx.scene.Node node = null; // a way of using the package javafx.scene.Node; w/o importing
//        org.w3c.dom.Node anotherNode = null; // a way of using the package javafx.scene.Node; w/o importing

        // using the fully qualified name instead of import
        Node node = null;
    }
}
