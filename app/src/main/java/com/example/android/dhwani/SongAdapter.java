package com.example.android.dhwani;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.songTextView = convertView.findViewById(R.id.song_text_view);
            holder.artistTextView = convertView.findViewById(R.id.artist_text_view);
            holder.thumbImageView = convertView.findViewById(R.id.thumbnail_image_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song currentSong = getItem(position);

        holder.thumbImageView.setImageResource(currentSong.getThumbID());

        // Find the TextView in the list_item.xml layout with the ID song_text_view
        // set this text on the name TextView
        holder.songTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID artist_text_view
        // set this text on the artistName TextView
        holder.artistTextView.setText(currentSong.getArtistName());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    static class ViewHolder {
        private TextView songTextView;
        private TextView artistTextView;
        private ImageView thumbImageView;
    }

}
