package com.example.android.dhwani;

public class Song {
    private String mSongName;

    private String mArtistName;

    private boolean mFavourite = false;

    private int mThumbID;

    public Song(String songName,String artistName, int songThumb){
        mSongName = songName;
        mArtistName = artistName;
        mThumbID = songThumb;
    }

    public String getSongName(){
        return mSongName;
    }

    public String getArtistName(){
        return mArtistName;
    }

    public int getThumbID() {
        return mThumbID;
    }

    public void setSongFavourite(){
        mFavourite = true;
    }
}
