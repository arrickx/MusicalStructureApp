package com.example.android.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        TextView currentSong = findViewById(R.id.current_song);
        TextView currentArtist = findViewById(R.id.current_artist);
        ImageView playLast = findViewById(R.id.last_song);
        ImageView pause = findViewById(R.id.pause_song);
        ImageView play = findViewById(R.id.play_song);
        ImageView playNext = findViewById(R.id.next_song);
        final String currentSongName = getIntent().getExtras().getString("songName");
        String currentArtistName = getIntent().getExtras().getString("artistName");

        // Set the current song and artist text to the correct TextView.
        currentSong.setText(currentSongName);
        currentArtist.setText(currentArtistName);

        // Set the onClick method for different button to show message when they were clicked.
        playLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this,
                        R.string.last_song, Toast.LENGTH_SHORT).show();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this,
                        R.string.pause_song, Toast.LENGTH_SHORT).show();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this,
                        "Now Playing " + currentSongName, Toast.LENGTH_SHORT).show();
            }
        });
        playNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this,
                        R.string.next_song, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
