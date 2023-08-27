package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String songTitle, double songDuration){

        if (findSong(songTitle) != null){  //if song already exists don't add
            return false;
        } else {                           //if song doesn't exist then add song
            Song newSong = new Song(songTitle, songDuration);
            songs.add(newSong);
            return true;
        }
        //return true if song was added successfully or false otherwise
    }

    private Song findSong(String songTitle){

        for (int i = 0; i < songs.size(); i++){
            if(songTitle.contains(songs.get(i).getTitle())){
                return songs.get(i);
            }
        }
        //i don't understand enhanced for loops
//        for (Song song : songs) {
//            if (songTitle.contains(song.getTitle())) {
//                return song;
//            }
//        }

        return null;
        //return Song if it exists and null if it doesn't
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> playlist){
        //return true if it exists, and it was added successfully using the track
        //number or false otherwise
        if(trackNum <=0 || trackNum > songs.size()){
            return false;
        }

        playlist.add(songs.get(trackNum - 1));
        return true;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist){
        //return true if it exists and it was added successfully using the track
        //number or false otherwise

        if(findSong(songTitle) != null){  //if song exists add to playlist
            playlist.add(findSong(songTitle));
            return true;
        }

        return false;
    }
}
