package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongsListActivity extends AppCompatActivity {
    @BindView(R.id.list)
    RecyclerView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Create an Array of songs
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("song 1", "artist 1"));
        songs.add(new Song("song 2", "artist 2"));
        songs.add(new Song("song 3", "artist 3"));
        songs.add(new Song("song 4", "artist 4"));
        songs.add(new Song("song 5", "artist 5"));
        songs.add(new Song("song 6", "artist 6"));

        // Set the adapter for the Recycler View songList by creating a new SongAdapter
        // that use songs that created above
        songList.setAdapter(new SongAdapter(songs));

        // Set layout manager to position the items
        songList.setLayoutManager(new LinearLayoutManager(this));

        // Use ItemClickSupport to perform an on item click event that open the new activity
        ItemClickSupport.addTo(songList).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        startActivity(new Intent(SongsListActivity.this, NowPlayingActivity.class)
                                .putExtra("songName", songs.get(position).getSongName())
                                .putExtra("artistName", songs.get(position).getSongArtist()));
                    }
                }
        );
    }
}
