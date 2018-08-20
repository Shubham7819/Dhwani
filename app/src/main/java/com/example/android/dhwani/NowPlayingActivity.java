package com.example.android.dhwani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        TextView songNameTV = findViewById(R.id.song_name);
        String songName = getIntent().getStringExtra("songName");
        songNameTV.setText(songName);

        TextView songArtistTV = findViewById(R.id.artist_name);
        String songArtist = getIntent().getStringExtra("songArtist");
        songArtistTV.setText(songArtist);

        ImageView songThumbIV = findViewById(R.id.thumb);
        int songThumbID = getIntent().getIntExtra("songThumb", 0);
        songThumbIV.setImageResource(songThumbID);

        ImageView library = findViewById(R.id.library_image_view);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlayingActivity.this,MainActivity.class);
            }
        });

        ImageView favourites = findViewById(R.id.favourites_image_view);
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlayingActivity.this, FavouriteActivity.class);
                startActivity(intent);
            }
        });

    }
}
