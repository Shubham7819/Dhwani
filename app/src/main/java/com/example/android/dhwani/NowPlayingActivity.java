package com.example.android.dhwani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.dhwani.MainActivity.songs;

// activity to show current playing song
public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // find ImageView for song thumbnail and store in songThumbIV variable
        ImageView songThumbIV = findViewById(R.id.thumb);
        // get image id of selected song and store
        int songThumbID = getIntent().getIntExtra(getString(R.string.song_thumb), 0);
        // set song image in imageView
        songThumbIV.setImageResource(songThumbID);

        // find ImageView for favourite icon and store in variable
        final ImageView makeFavouriteIV = findViewById(R.id.makeFavouriteIV);
        // get value of songFavourite whether song is favourite
        final boolean songFavourite = getIntent().getBooleanExtra(getString(R.string.song_favourite),
                false);
        // check if song favourite and set image
        if (songFavourite) {
            makeFavouriteIV.setImageResource(R.drawable.heart_filled);
        } else {
            makeFavouriteIV.setImageResource(R.drawable.heart_empty);
        }

        // get selected song position in ArrayList and store
        // make song favourite if not
        final int songPosition = getIntent().getIntExtra(getString(R.string.song_position), 0);
        makeFavouriteIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (songs.get(songPosition).isSongFavourite()) {
                    songs.get(songPosition).setSongUnFavourite();
                    makeFavouriteIV.setImageResource(R.drawable.heart_empty);
                    Toast.makeText(NowPlayingActivity.this, R.string.favourite_removed, Toast.LENGTH_SHORT).show();
                } else {
                    songs.get(songPosition).setSongFavourite();
                    makeFavouriteIV.setImageResource(R.drawable.heart_filled);
                    Toast.makeText(NowPlayingActivity.this, R.string.favourite_added, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // find textView for song name
        // get song name from intent and set on textView
        TextView songNameTV = findViewById(R.id.song_name);
        String songName = getIntent().getStringExtra(getString(R.string.song_name));
        songNameTV.setText(songName);

        // get song Artist name from intent and set on textView
        TextView songArtistTV = findViewById(R.id.artist_name);
        String songArtist = getIntent().getStringExtra(getString(R.string.song_artist));
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
