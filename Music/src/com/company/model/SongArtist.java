package com.company.model;

public class SongArtist {
    private String artistName;
    private String albumName;
    private int track;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    // SELECT * FROM songs WHERE title = "Heartless"
    // SELECT * FROM albums WHERE _id = 308
    // SELECT * FROM artists WHERE _id = 39

    // SELECT * FROM songs WHERE title LIKE = "She's On Fire"
    // SELECT * FROM albums WHERE _id = 248
    // SELECT * FROM artists WHERE _id = 7

    // SELECT * FROM songs WHERE title = "Go Your Own Way"
    // SELECT * FROM albums WHERE _id = 416
    // SELECT * FROM artists WHERE _id = 5


}
