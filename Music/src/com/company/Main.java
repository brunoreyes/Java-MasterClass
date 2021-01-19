package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;
import com.company.model.SongArtist;

import java.util.List;

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
        
        datasource.close();
    }
}
