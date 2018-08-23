package com.example.android.musicalstructureapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link SongAdapter} is an {@link RecyclerView.Adapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Song} objects.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    // Store a member variable for the contacts
    private List<Song> mSong;

    // Pass in the contact array into the constructor
    public SongAdapter(List<Song> songs) {
        mSong = songs;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.list_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Song song = mSong.get(position);

        // Set item views based on your views and data model
        TextView textView1 = viewHolder.songNameTextView;
        textView1.setText(song.getSongName());
        TextView textView2 = viewHolder.artistNameTextView;
        textView2.setText(song.getSongArtist());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mSong.size();
    }

    // Provide a direct reference to each of the views within a data item
    // by using ButterKnife for cleaner experience
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.song_name) TextView songNameTextView;
        @BindView(R.id.artist_name) TextView artistNameTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
