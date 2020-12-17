package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        } return false;
    }
    private Song findSong(String title){
        for (Song checkedSong: this.songs){ // for each song in the list, assign a variable to it
            if(checkedSong.getTitle().equals(title)){ // check to see if the song is within the Songs ArrayList
                return checkedSong; // adding the new song
            }
        } return null; // song already existed
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1;
        if((index >= 0) && (index <= this.songs.size())){ // ensuring there's a song in the list
            playList.add(this.songs.get(index));
            return true;
        } // If the song isn't there
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }



}
