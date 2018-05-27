package com.example.android.musicalstructureapp;

/**
 * {@link Song} represents a song's detail.
 * It contains the name and the artist of the song.
 */
public class Song {

    /**
     * The name of the song.
     */
    private String mSongName;

    /**
     * The artist of the song
     */
    private String mSongArtist;

    public Song(String SongName, String SongArtist) {
        mSongName = SongName;
        mSongArtist = SongArtist;
    }

    /**
     * Get the name of the song.
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the artist of the song.
     */
    public String getSongArtist() {
        return mSongArtist;
    }
}
