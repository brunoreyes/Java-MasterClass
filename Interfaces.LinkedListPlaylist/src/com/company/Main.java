package com.company;

// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove())

import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>(); // changed the hardcoded linkedList to generic list

    public static void main(String[] args) {
        Album album = new Album("StormBringer", "Deep Purple");
        album.addSong("StormBringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

        List<Song> playList = new ArrayList<Song>(); // arrayList implements the base methods of List
                                                    //   and so does Vector, LinkedList
        albums.get(0).addToPlayList("You can't do it right",playList); // album(0) = "Deep Purple", seeing if songs there
        albums.get(0).addToPlayList("SlowBall",playList); // checking songs that aren't in the album
        albums.get(1).addToPlayList("Evil walks",playList);
        albums.get(0).addToPlayList("C.O.D.",playList); // checking if song from wrong album will add
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(0).addToPlayList(24, playList); // trying adding out of reach track number

        play(playList);
    }

    private static void play(List<Song> playList) {// changed the hardcoded linkedList to generic List
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3: // replaying: taking into account going forward, going backwards or staying on the same song
                        if(forward){
                            if(listIterator.hasPrevious()){
                                System.out.println("Now replaying " + listIterator.previous().toString());
                                forward = false;
                            } else System.out.println("We are at the start of the list");
                        } else {
                            if(listIterator.hasNext()){
                                System.out.println("Now replaying " +listIterator.next().toString());
                            } else System.out.println("We have reached the end of the list");
                        }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6: // deleting the current song and accounting for next and previous songs
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous());
                        }
                    } break; // getting an exception
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available Actions: \npress");
        System.out.println("0 - to quit \n" +
                "1 - to play next song \n" +"" +
                "2 - to play previous song \n" +
                "3 - replay current song \n" +
                "4 - to list songs in playlist \n" +
                "5 - print available actions \n" +
                "5 - to delete current song");
    }

    private static void printList(List<Song>playList){ // changed the hardcoded linkedList to list
        Iterator<Song> iterator = playList.iterator();
        System.out.println("============================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        } System.out.println("===============================");
    }

}
