package com.example.jennandon.queueandeh;

/**
 * Created by duncanmacfarlane on 2017-02-21.
 */
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

//import static com.example.jennandon.queueandeh.R.raw.thought;

/*

public class Sounds {


//FX: plays a background sound effect
    public void OnCreate() {
        MediaPlayer player;
        AssetFileDescriptor afd;
        try {
            // Read the music file from the resource folder
            afd = getAssets().openFd("thought1.wav");
            // Creation of new media player;
            player = new MediaPlayer();
            // Set the player music source.
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            // Set the looping and play the music.
            player.setLooping(true);
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void onStop() {
        super.onStop();
        player.stop();
        player = null;
    }
}
/*
