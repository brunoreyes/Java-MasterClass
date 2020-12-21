package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    // Adopting the accepted conventions for naming variables, methods, and objects in Java
    // makes code easier to read.

    // Java's unique naming conventions for the following:

        // Packages: always lower case, unique name, internet domain name reversed as a prefix to package name
            // Invalid domain name components:
                // - Replace invalid characters (i.e. -) in domain name with an underscore
                // - Domain names starting with a number should instead start with an underscore (_)
                // - Domain name components that are Java keywords should start with an underscore (_)
            // For example:
                // Replace "Switch.supplier.com" with "com.supplier._switch"
                // Replace "1world.com" with "com._1word "
                // Replace "Experts-exchange.com" with "com.experts_exchange"
            // Example package names:
                // - java.lang
                // - java.io
                // - org.xml.sax.helpers
                // - com.company

        // Classes: camelCase, should be nouns (representing things) that start with a capital letter
            // For example: ArrayList, LinkedList, TopSong


        // Interfaces: Capitalized, consider objects implementing the interface will become or able to do.
            // For example: List, Comparable, Serializable


        // Methods: mixedCase (camelCase unless one word, than lowercase) ,
        //          often verbs reflecting the function performed or results returned
            // For example: addPlayer(), printLedger();, size()


        // Constants: ALL UPPERCASE, separating words w/ underscore (_), and declared using the "final" keyword
            // For example:
                // - Static final int MAX_INT
                // - Static final short SEVERITY_ERROR
                // - Static final double PI == 3.141592623


        // Variables: camelCase, meaningful & indicative, no underscores(_)
            // For example: i, league, sydneySwans, boxLength


        // Type Parameters: single character, capital letters
            // E - Element (used extensively by the Java Collections Framework)
            // K - Key
            // T - Type
            // V - Value
            // S,U,V,etc. - 2nd, 3rd, and 4th types

    }
}
