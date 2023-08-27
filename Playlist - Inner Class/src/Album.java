import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();

//        this.songs = new ArrayList<>();
    }

    public boolean addSong(String songTitle, double songDuration){

        return this.songs.add(new Song(songTitle, songDuration));
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> playlist){
        //return true if it exists, and it was added successfully using the track
        //number or false otherwise
        if(trackNum <=0 || trackNum > songs.songs.size()){
            return false;
        }

        return playlist.add(songs.songs.get(trackNum - 1));
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist){
        //return true if it exists and it was added successfully using the track
        //number or false otherwise

        if(songs.findSong(songTitle) != null){  //if song exists add to playlist
            playlist.add(songs.findSong(songTitle));
            return true;
        }

        return false;
    }

    public static class SongList{

        private ArrayList<Song> songs = new ArrayList<>();

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song){

            if(findSong(song.getTitle()) == null){
                songs.add(song);
                return true;
            }

            return false;
        }

        private Song findSong(String songTitle){

            for (Song song : songs) {
                if (songTitle.contains(song.getTitle())) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){

            for (Song song : songs) {
                if (songs.size() < trackNumber) {
                    return songs.get(trackNumber - 1);
                }
            }
            return null;
        }

    }
}
