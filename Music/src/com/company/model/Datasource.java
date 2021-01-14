package com.company.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Artist> queryArtist(){
        Statement statement = null;
        ResultSet results = null;

        try {
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);

            // Creating a list called artists, comprised of Artist objects
            List<Artist> artists = new ArrayList<>();
            while (results.next()){ // while there is a next artist
                Artist artist = new Artist();
                artist.setId(results.getInt(COLUMN_ARTIST_ID));
                artist.setName(results.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;

        } catch (SQLException e){
            System.out.println("Query failed: " + e.getMessage());
            return null;
        } finally {
            try {
                if (results != null){
                    results.close();
                }
            } catch (SQLException e){
                System.out.println("Error closing ResultSet " + e.getMessage());
            }
            try {
                if (statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                System.out.println("Error closing Statement "  + e.getMessage());
            }
        }
    }
}
