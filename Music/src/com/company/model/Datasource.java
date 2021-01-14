package com.company.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING =
            "jdbc:sqlite:/Users/brunoreyes/Desktop/Code/Java/Java-MasterClass/Music/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "albums";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection connection;

    public boolean open(){
        try{
            connection = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to a database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void close(){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e){
            System.out.println("Couldn't close connection " +  e.getMessage());
        }
    }
}
