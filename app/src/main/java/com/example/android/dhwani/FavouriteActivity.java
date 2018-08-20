package com.example.android.dhwani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        ListView list = findViewById(R.id.list);
        SongAdapter adapter = new SongAdapter(this,MainActivity.songs);
    }
}
