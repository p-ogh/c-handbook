package testdome.java;

import java.util.HashSet;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        boolean isRepeat = false;


//        if(nextSong.nextSong != null){
//            return true;
//        }

    //    LinkedList<Song> playlist = new LinkedList<>();

        //for speed use HashSet, hashSet is generally faster compared to LinkedList
        HashSet<Song> playlist = new HashSet<>();

        Song song = nextSong;

        while(song !=null){
            if(playlist.contains(song)){
                return true;
            }
            playlist.add(song);
            song = song.nextSong;
        }


        return isRepeat;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}
