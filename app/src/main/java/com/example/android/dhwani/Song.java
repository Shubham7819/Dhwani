package com.example.android.dhwani;

// class definition to store data of song
public class Song {
    // variable to store song name
    private String mSongName;

    // variable to store artist name
    private String mArtistName;

    // variable to store song favourite value
    private boolean mFavourite = false;

    // variable to store song thumbnail id
    private int mThumbID;

    // constructor to create object
    public Song(String songName, String artistName, int songThumb){
        mSongName = songName;
        mArtistName = artistName;
        mThumbID = songThumb;
    }

    // @return name of song
    public String getSongName(){
        return mSongName;
    }

    // @return name of artist
    public String getArtistName(){
        return mArtistName;
    }

    // @return song thumbnail id
    public int getThumbID() {
        return mThumbID;
    }

    // function to check if song is favourite
    // @return true if song is favourite and false if not
    public boolean isSongFavourite() {
        if (mFavourite){
            return true;
        } else {
            return false;
        }
    }

    // make song favourite
    public void setSongFavourite(){
        mFavourite = true;
    }

    // remove song from favourite
    public void setSongUnFavourite() {
        mFavourite = false;
    }
}
