package com.company;


// JDBC stands for Java Database Connectivity, allowing us to not only work with databases,
// but also spreadsheets and flat files.

// JDBC acts as a middleman between a Java application and a data source.
// To use a particular data source from an app, we need the JDBC driver for the data source.
// For ex: To access an sqlite database from an app, I'll need an sqlite JDBC driver.

// The driver is simply a Java library containing classes that implement the JDBC API.
// All JDBC drivers have to implement the same interfaces, so it's not difficult to change
// the data source an app uses.

// So if I wanted to use a MySQL DB (database) instead of SQLite, I would simply use
// the MySQL JDBC driver, instead of SQLite and migrate the data to the MySQL DB.
// However this process of migration isn't always 100% portable.

// If we want to work with spreadsheets or flat files, their is JDBC drivers that work
// in those formats. I also have the ability to write a customized JDBC driver if necessary.

// The JDBC driver is always written in Java, but can consist of a thin Java layers that
// call code written in other languages.
// JDBC API updated versions contain backwards compatibility with previous versions

// JDBC consist of two packages java.sql (core JDBC) & javax.sql (optional JDBC).

// All JDK's ship with a database called derby which can be used on desktops or when prototyping

// Adding JDBC to a Java Project
// File > Project Structure > Libraries >> "+" button >> go to JDBC.jar file > add it

import java.sql.*;

public class Main {
    // All JDBC drivers use a connection string to connect to a DB, using JDBC:

    public static void main(String[] args) {
        // Utilized absolute path and changed it so it doesn't go into src but: TestDataBase
       //  Using try & catch with resources to automatically close the resource when try & catch block exits
        try (Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:/Users/brunoreyes/Desktop/Code/Java/" +
                        "Java-MasterClass/TestDataBase/testjava.db");
             Statement statement = connection.createStatement()){

//        try {
//            Connection connection = DriverManager.getConnection(
//                "jdbc:sqlite:/Users/brunoreyes/Desktop/Code/Java/" +
//                        "Java-MasterClass/TestDataBase/testjava.db");
            //connection.setAutoCommit(false); // turning off auto commit to not automatically add data
//            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS" + //  only creates table "IF NOT EXISTS"
                    " contacts (name TEXT, phone INTEGER, email TEXT)");
            // when calling execute() the driver understands I'm passing a complete query so no ";"
            // semicolon is need at the end of the statement.

//            Commenting out Inserts to avoid adding duplicate data
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    " VALUES ('Bruno', 1234567890, 'bruno@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    " VALUES ('Joe', 0987654321, 'joe@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    " VALUES ('Mojo', 1234567899, 'mojo@email.com')");

            statement.execute("UPDATE contacts SET phone=5566798 WHERE name='Joe'");
            statement.execute("DELETE FROM contacts WHERE name='Bruno'");
            statement.execute("SELECT * FROM contacts");

            // Recall to use different statement instances for each query when using or checking data
            // Above is okay because we are only preforming CRUD and not using or checking data
            ResultSet results = statement.getResultSet(); // Gathering data from SQL database using ResultSet.
            while (results.next()){
                System.out.println(results.getString("name")
                    + " " + results.getString("phone")
                    + " " + results.getString("email"));
            }
            results.close();
            


            // Connection is connection to db and statement is the statement that you want to execute.
            // Remember: Always Close statements before closing connections if not using try/catch w/ resources
//            statement.close();
//            connection.close();

        } catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
