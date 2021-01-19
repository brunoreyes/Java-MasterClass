package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;
import com.company.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    // Ensure to import JDBC driver via project structure >> library
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()){
            System.out.println("Can't open datasource");
            return;
        }
        List<Artist> artists = datasource.queryArtist(5);
        if (artists == null){
            System.out.println("No artist!");
            return;
        }

        for ( Artist artist: artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }
        List<String> albumsForArtist = 
//                datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);
        datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_DESC);


        for (String album: albumsForArtist) {
            System.out.println(album);
        }

        // Getting the artist and song info of a song
//        List<SongArtist> songArtists = datasource.queryArtistsForSong("Heartless", Datasource.ORDER_BY_ASC);
        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if (songArtists == null){
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for(SongArtist artist: songArtists){
            System.out.println("Artist: " + artist.getArtistName() +
                    ", Album: " + artist.getAlbumName() +
                    ", Track: " + artist.getTrack());
        }

        // getting the column names of song table
        datasource.querySongsMetaData();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        //
        datasource.createViewForSongArtists();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();
        songArtists = datasource.querySongInfoView(title);
        // "Go Your Own Way" or 1=1 or " // this is a sequel injection attack,
        // is when a user injects sequel into the statement that's not intended to run
        // gathering data from all tables
        // since 1=1 for every record, all the artist_ list view are returned
        // 1st Scenario: SELECT name, album, track FROM artist_list WHERE title =  "Go Your Own Way" or 1=1 or ""

        // Prepared statements class can protect against sequel injection attacks bc when used,
        // we don't concatenate a user statement that would be running
        // nothing in the string value is treated as equal
        // 2ns Scenario: SELECT name, album, track FROM artist_list WHERE title =  "Go Your Own Way or 1=1 or ""
        // 2nd scenario uses a placeholder, and now anything substituted for the placeholder is treated as a single
        // literal value that will not being interpreted by SQL.

        // Do the following to use a PreparedStatement to protect against certain SQL Injection attacks:
        // 1. Declare a constant for the SQL statement that contains the placeholders
        // 2. Create a PreparedStatement instance using: Connection.prepareStatement(sqlStmtString)
        // 3. When ready to preform the query ( aka search ), (or insert, update, delete), we call the appropriate
        //    setter methods to set the placeholders to the values we want to use in the statement
        // 4. We run the statement using: PreparedStatement.execute() or PreparedStatement.executeQuery()
        // 5. We process the results the same way we do using a regular old Statement

        // Transactions

        // JDBC Connection automatically commits changes like executing insert, update, or deleting records. These
        // changes are saved to the database as soon as the SQL statement completes which isn't ideal.

        // For that reason if we wanted to accomplish something that required multiple SQL statements, we could run all
        // the statements as a single unit. Enabling either all the SQL statements to successfully complete or none complete.

        // A Transaction is a sequence of SQL statements that are treated as a single logical unit.
        // If any of the statements fail, the results of any previous statements in the transaction can be rolled back
        // or just not saved, making them appear as if they never happened.

        // In a banking scenario, if step two fails, then the balance in the source account would be rolled back to it's
        // original value. If step 1 and 2 are successful but step 3 fails then step 1 & 2 are rolled back, as if nothing happened.

        // When speaking about databases, we usually use the term commit, rather than save, when referring to making changes permanent.

        // Database transactions must be ACID-compliant, meeting the following characteristics:
        // 1. Atomicity - If a series of SQL statements change the database, then either all the changes are committed or none of them are.
        // 2. Consistency - Before a transaction begins, the database is in a valid state, when it completes, it' still in a valid state.
        // 3. Isolation - Until the changes committed by a transaction are completed, they won't be visible to other connections.
        //    Transactions cannot depend on each other.
        // 4. Durability - Once th changes performed by a transaction are committed to the database, they're permanent.
        //    If an app crashes or the DB server goes down, the changes made by the transaction are still there when the
        //    app runs again or the DB comes back up.

        // Essentially, transactions ensure the integrity of data within a database.


//        songArtists = datasource.querySongInfoView("Heartless");

        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track number = " + artist.getTrack());
        }
        
        datasource.close();
    }
}
