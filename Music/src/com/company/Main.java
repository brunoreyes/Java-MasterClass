package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;

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
        
        datasource.close();
    }
}
