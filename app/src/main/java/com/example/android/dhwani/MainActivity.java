package com.example.android.dhwani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Song> songs;

    ListView listView;

    SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        doStuff();
    }

    public void doStuff(){
        songs = new ArrayList<Song>();
        listView = (ListView) findViewById(R.id.list);
        getMusic();
        adapter = new SongAdapter(this, songs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                intent.putExtra("songName", songs.get(position).getSongName());
                intent.putExtra("songArtist", songs.get(position).getArtistName());
                intent.putExtra("songThumb", songs.get(position).getThumbID());
                startActivity(intent);
            }
        });
    }

    public void getMusic(){

        songs.add(new Song("Masakali", "A.R. Rahman", R.drawable.masakali));
        songs.add(new Song("Dil ka jo haal hai", "Abhijeet & Shreya Ghoshal",
                R.drawable.dil_ka_jo));
        songs.add(new Song("Waada raha sanam", "Abhijeet",
                R.drawable.waada_raha));
        songs.add(new Song("Bhar do jholi meri", "Adnan sami",
                R.drawable.bhar_do_jholi));
        songs.add(new Song("Hip don't lie", "Shakira", R.drawable.hip_dont));
        songs.add(new Song("Channa mereya", "Pritam & Arijit singh",
                R.drawable.channa_mereya));
        songs.add(new Song("Bulleya", "Papon", R.drawable.bulleya));
        songs.add(new Song("Labon ka karobaar", "Papon", R.drawable.labon_ka));
        songs.add(new Song("Chahun main ya naa", "Palak muchhal",
                R.drawable.chahun_main));
        songs.add(new Song("Mere bina", "Nikhil dsouza", R.drawable.mere_bina));
        songs.add(new Song("Kheech meri photo",
                "Neeti mohan, Akasa singh & Darshan raval", R.drawable.kheech_meri_photo));
        songs.add(new Song("Papa toh band bajaye", "Neeraj Sridhar",
                R.drawable.papa_toh));
        songs.add(new Song("Sawaar loon", "Monali thakur",
                R.drawable.sawaar_loon));
        songs.add(new Song("Abhi kuch dino se", "Mohit Chauhan",
                R.drawable.abhi_kuch_dino));
        songs.add(new Song("Daaru Party", "Millind gaba",
                R.drawable.daaru_party));

    }

}
