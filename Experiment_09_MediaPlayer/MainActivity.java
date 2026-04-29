package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // MediaPlayer object — the engine that plays audio
    MediaPlayer mediaPlayer;

    Button btnPlay, btnPause, btnStop;
    SeekBar seekBar;
    TextView tvStatus, tvCurrentTime, tvTotalTime;

    // Handler to update SeekBar every second
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link all UI elements
        btnPlay       = findViewById(R.id.btnPlay);
        btnPause      = findViewById(R.id.btnPause);
        btnStop       = findViewById(R.id.btnStop);
        seekBar       = findViewById(R.id.seekBar);
        tvStatus      = findViewById(R.id.tvStatus);
        tvCurrentTime = findViewById(R.id.tvCurrentTime);
        tvTotalTime   = findViewById(R.id.tvTotalTime);

        // -------------------------------------------------------
        // Create MediaPlayer with song from res/raw/song.mp3
        // R.raw.song = references res/raw/song.mp3
        // -------------------------------------------------------
        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        // Set SeekBar max = total song duration (in milliseconds)
        seekBar.setMax(mediaPlayer.getDuration());

        // Show total song duration
        tvTotalTime.setText(formatTime(mediaPlayer.getDuration()));

        // -------------------------------------------------------
        // PLAY BUTTON
        // -------------------------------------------------------
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start(); // Start or resume playback
                    tvStatus.setText("Status: ▶ Playing...");
                    updateSeekBar(); // Start updating SeekBar
                }
            }
        });

        // -------------------------------------------------------
        // PAUSE BUTTON
        // -------------------------------------------------------
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause(); // Pause — keeps position
                    tvStatus.setText("Status: ⏸ Paused");
                }
            }
        });

        // -------------------------------------------------------
        // STOP BUTTON
        // -------------------------------------------------------
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();     // Stop playback
                    mediaPlayer.reset();    // Reset to beginning
                    // Recreate MediaPlayer after reset
                    mediaPlayer = MediaPlayer.create(
                            MainActivity.this, R.raw.song);
                    seekBar.setProgress(0); // Reset SeekBar to 0
                    tvCurrentTime.setText("0:00");
                    tvStatus.setText("Status: ⏹ Stopped");
                }
            }
        });

        // -------------------------------------------------------
        // SEEKBAR — User drags to jump to a position in song
        // -------------------------------------------------------
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar,
                                          int progress, boolean fromUser) {
                if (fromUser) {
                    // User dragged SeekBar → jump to that position
                    mediaPlayer.seekTo(progress);
                    tvCurrentTime.setText(formatTime(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Auto-stop when song finishes
        mediaPlayer.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                seekBar.setProgress(0);
                tvCurrentTime.setText("0:00");
                tvStatus.setText("Status: ✅ Completed");
            }
        });
    }

    // -------------------------------------------------------
    // Updates SeekBar every 500ms while song is playing
    // Uses Handler + Runnable to run repeatedly
    // -------------------------------------------------------
    private void updateSeekBar() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    int currentPos = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(currentPos);
                    tvCurrentTime.setText(formatTime(currentPos));
                    updateSeekBar(); // Call again after 500ms
                }
            }
        }, 500);
    }

    // -------------------------------------------------------
    // Converts milliseconds to "M:SS" format
    // Example: 75000ms → "1:15"
    // -------------------------------------------------------
    private String formatTime(int milliseconds) {
        int seconds = (milliseconds / 1000) % 60;
        int minutes = (milliseconds / 1000) / 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    // -------------------------------------------------------
    // VERY IMPORTANT: Release MediaPlayer when Activity closes
    // Prevents memory leaks
    // -------------------------------------------------------
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Free all resources
            mediaPlayer = null;
        }
    }
}