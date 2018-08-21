package com.example.android.dhwani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.dhwani.MainActivity.songs;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ImageView songThumbIV = findViewById(R.id.thumb);
        int songThumbID = getIntent().getIntExtra("songThumb", 0);
        songThumbIV.setImageResource(songThumbID);

        final ImageView makeFavouriteIV = findViewById(R.id.makeFavouriteIV);
        final boolean songFavourite = getIntent().getBooleanExtra("songFavourite", false);
        if (songFavourite) {
            makeFavouriteIV.setImageResource(R.drawable.heart_filled);
        } else {
            makeFavouriteIV.setImageResource(R.drawable.heart_empty);
        }

        final int songPosition = getIntent().getIntExtra("songPosition", 0);
        makeFavouriteIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (songs.get(songPosition).isSongFavourite()) {
                    songs.get(songPosition).setSongUnFavourite();
                    makeFavouriteIV.setImageResource(R.drawable.heart_empty);
                    Toast.makeText(NowPlayingActivity.this, "Song removed from Favourites", Toast.LENGTH_SHORT).show();
                } else {
                    songs.get(songPosition).setSongFavourite();
                    makeFavouriteIV.setImageResource(R.drawable.heart_filled);
                    Toast.makeText(NowPlayingActivity.this, "Song added to Favourites", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView songNameTV = findViewById(R.id.song_name);
        String songName = getIntent().getStringExtra("songName");
        songNameTV.setText(songName);

        TextView songArtistTV = findViewById(R.id.artist_name);
        String songArtist = getIntent().getStringExtra("songArtist");
        songArtistTV.setText(songArtist);

        ImageView previousButton = findViewById(R.id.btnPrevious);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView playButton = findViewById(R.id.btnPlay);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
