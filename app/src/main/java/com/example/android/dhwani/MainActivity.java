package com.example.android.dhwani;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// Musical Structure app
// layout a music playing app that displays the list of available songs in a ListView
public class MainActivity extends AppCompatActivity {

    // create an ArrayList for storage of songs(object of Song class)
    static ArrayList<Song> songs;

    // creates ListView variable for showing songs in list
    ListView listView;

    // adapter to populate the layout with views
    private SongAdapter adapter;

    Intent nowPlayingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        doStuff();

        //  find and store object of nowPlayingButton
        Button nowPlayingButton = findViewById(R.id.btnNowPlaying);
        // open NowPlayingActivity when user click on button
        nowPlayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nowPlayingIntent == null) {
                    Toast.makeText(MainActivity.this, R.string.now_playing_empty,
                            Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(nowPlayingIntent);
                }
            }
        });
    }

    public void doStuff(){
        songs = new ArrayList<>();
        listView = findViewById(R.id.list);
        getMusic();
        adapter = new SongAdapter(this, songs);
        listView.setAdapter(adapter);

        // handle click events on listItems and pass extra data to NowPlayingActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nowPlayingIntent = new Intent(MainActivity.this,
                        NowPlayingActivity.class);
                nowPlayingIntent.putExtra(getString(R.string.song_name),
                        songs.get(position).getSongName());
                nowPlayingIntent.putExtra(getString(R.string.song_artist),
                        songs.get(position).getArtistName());
                nowPlayingIntent.putExtra(getString(R.string.song_thumb),
                        songs.get(position).getThumbID());
                nowPlayingIntent.putExtra(getString(R.string.song_favourite),
                        songs.get(position).isSongFavourite());
                nowPlayingIntent.putExtra(getString(R.string.song_position), position);
                startActivity(nowPlayingIntent);
            }
        });
    }

    // this method creates objects of Song class
    public void getMusic(){

        songs.add(new Song(getString(R.string.masakali), getString(R.string.ar_rahman),
                R.drawable.masakali));
        songs.add(new Song(getString(R.string.dil_ka_jo_haal), getString(R.string.abhijeet_shreya),
                R.drawable.dil_ka_jo));
        songs.add(new Song(getString(R.string.waada_raha_sanam), getString(R.string.abhijeet),
                R.drawable.waada_raha));
        songs.add(new Song(getString(R.string.bhar_do_jholi), getString(R.string.adnan_sami),
                R.drawable.bhar_do_jholi));
        songs.add(new Song(getString(R.string.hip_dont), getString(R.string.shakira),
                R.drawable.hip_dont));
        songs.add(new Song(getString(R.string.channa_mereya), getString(R.string.pritam_arijit),
                R.drawable.channa_mereya));
        songs.add(new Song(getString(R.string.bulleya), getString(R.string.papon),
                R.drawable.bulleya));
        songs.add(new Song(getString(R.string.labon_ka), getString(R.string.papon),
                R.drawable.labon_ka));
        songs.add(new Song(getString(R.string.chahun_main_ya), getString(R.string.palak_muchhal),
                R.drawable.chahun_main));
        songs.add(new Song(getString(R.string.mere_bina), getString(R.string.nikhil),
                R.drawable.mere_bina));
        songs.add(new Song(getString(R.string.kheech_meri_photo),
                getString(R.string.neeti_akasa_darshan), R.drawable.kheech_meri_photo));
        songs.add(new Song(getString(R.string.papa_toh), getString(R.string.neeraj),
                R.drawable.papa_toh));
        songs.add(new Song(getString(R.string.sawaar_loon), getString(R.string.monali),
                R.drawable.sawaar_loon));
        songs.add(new Song(getString(R.string.abhi_kuch), getString(R.string.mohit),
                R.drawable.abhi_kuch_dino));
        songs.add(new Song(getString(R.string.daaru_party), getString(R.string.millind),
                R.drawable.daaru_party));

    }

}
