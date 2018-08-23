package com.example.android.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlayingActivity extends AppCompatActivity {
    @BindView(R.id.current_song) TextView currentSong;
    @BindView(R.id.current_artist) TextView currentArtist;
    @BindView(R.id.last_song) ImageView playLast;
    @BindView(R.id.pause_song) ImageView pause;
    @BindView(R.id.play_song) ImageView play;
    @BindView(R.id.next_song) ImageView playNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ButterKnife.bind(this);

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
