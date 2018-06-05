package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an Array of songs
        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("song 1", "artist 1"));
        songs.add(new Song("song 2", "artist 2"));
        songs.add(new Song("song 3", "artist 3"));
        songs.add(new Song("song 4", "artist 4"));
        songs.add(new Song("song 5", "artist 5"));
        songs.add(new Song("song 6", "artist 6"));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared
        // in the activity_main.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link listView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Create onItemClick to open NowPlayingActivity.
        // Pass the songName and artistName into the NowPlayingActivity by getting
        // the current onClick position.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(SongsListActivity.this, NowPlayingActivity.class)
                        .putExtra("songName", songs.get(position).getSongName())
                        .putExtra("artistName", songs.get(position).getSongArtist()));
            }
        });

    }
}
