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
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING =
            // Utilized absolute path and changed it so it doesn't go into src but: TestDataBase
            "jdbc:sqlite:/Users/brunoreyes/Desktop/Code/Java/Java-MasterClass/TestDataBase/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

       //  Using try & catch with resources to automatically close the resource when try & catch block exits
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = connection.createStatement()){

//        try {
//            Connection connection = DriverManager.getConnection(
//                "jdbc:sqlite:/Users/brunoreyes/Desktop/Code/Java/" +
//                        "Java-MasterClass/TestDataBase/testjava.db");
            //connection.setAutoCommit(false); // turning off auto commit to not automatically add data
//            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF NOT EXISTS" + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS" + TABLE_CONTACTS +//  only creates table "IF NOT EXISTS"
                                " (" + COLUMN_NAME + " TEXT,"
                                + COLUMN_PHONE + " INTEGER,"
                                + COLUMN_EMAIL +" TEXT)");

            // when calling execute() the driver understands I'm passing a complete query so no ";"
            // semicolon is need at the end of the statement.

//            Commenting out Inserts to avoid adding duplicate data
            statement.execute("INSERT INTO "+ TABLE_CONTACTS +
                                    " (" + COLUMN_NAME + ", " +
                                    COLUMN_PHONE + ", " +
                                    COLUMN_EMAIL + ") " +
                                " VALUES ('Bruno', 1234567890, 'bruno@email.com')");
            statement.execute("INSERT INTO "+ TABLE_CONTACTS +
                                    " (" + COLUMN_NAME + ", " +
                                     COLUMN_PHONE + ", " +
                                     COLUMN_EMAIL + ") " +
                                    " VALUES ('Joe', 0987654321, 'joe@email.com')");
            statement.execute("INSERT INTO "+ TABLE_CONTACTS +
                                    " (" + COLUMN_NAME + ", " +
                                    COLUMN_PHONE + ", " +
                                    COLUMN_EMAIL + ") " +
                                    " VALUES ('Mojo', 1234567899, 'mojo@email.com')");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE +
                                    "=5566798 WHERE " + COLUMN_NAME + "='Joe'");
            statement.execute("DELETE FROM  " + TABLE_CONTACTS +
                                    " WHERE  " + COLUMN_NAME + "='Bruno'");
//            statement.execute("SELECT * FROM contacts");

            // Recall to use different statement instances for each query when using or checking data
            // Above is okay because we are only preforming CRUD and not using or checking data
//            ResultSet results = statement.getResultSet(); // Gathering data from SQL database using ResultSet.
            // executeQuery returns a result set

            // hardcoding strings create vulnerability to sequel injection attacks
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()){
                System.out.println(results.getString(COLUMN_NAME)
                    + " " + results.getString(COLUMN_PHONE)
                    + " " + results.getString(COLUMN_EMAIL));
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
