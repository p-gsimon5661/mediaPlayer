package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.riseandshine);

        Button play    = findViewById(R.id.play_button);
        Button pause   = findViewById(R.id.pause_button);
        Button volup   = findViewById(R.id.upVol_button);
        Button voldwon = findViewById(R.id.downVol_button);
        Button seek    = findViewById(R.id.seek_button);

        // Set a click listener on that View
        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion (MediaPlayer mediaPlayer)
                    {
                       Toast.makeText(MainActivity.this, "I'm Done!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        pause.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.pause();
            }

        });

        volup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.setVolume(1.0f, 1.0f);
            }
        });

        voldwon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(mediaPlayer.isPlaying())
                    mediaPlayer.setVolume(0.0f, 0.0f);
            }
        });

        seek.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if( mediaPlayer.isPlaying() )
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 10000);
            }
        });
    }
}
