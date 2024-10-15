package com.trup1.euphoria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.IOException;

public class song2 extends AppCompatActivity {
    private MediaPlayer mediaplayer1;
    ToggleButton playPauseButton;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song2);

        playPauseButton = findViewById(R.id.playPauseButton);
        SeekBar seekBar = findViewById(R.id.seekBar);


        mediaplayer1 = MediaPlayer.create(this, R.raw.faded_11);


        MusicHolder1();
        {

            MediaPlayer finalMediaPlayer = mediaplayer1;
            playPauseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (playPauseButton.isChecked()) {
                        finalMediaPlayer.start();

                    } else {
                        finalMediaPlayer.pause();

                    }
                }
            });
            View backbtn = findViewById(R.id.back);

            backbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaplayer1.stop();

                    startActivity(new Intent(song2.this, MusicPlayerActivity.class));
                    finish();

                }
            });
            View forward = findViewById(R.id.btnforward);

            forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaplayer1.stop();

                    startActivity(new Intent(song2.this, song3.class));
                    finish();

                }
            });
        }
        mediaplayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Reset seekbar progress to 0
                seekBar.setProgress(0);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaplayer1.seekTo(progress * mediaplayer1.getDuration() / 100);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Called when user starts touching the seekbar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Called when user stops touching the seekbar
            }
        });

    }
    @Override
    public void onBackPressed() {
        mediaplayer1.stop();
        super.onBackPressed();
    }
    public void MusicHolder1() {
    }

}


