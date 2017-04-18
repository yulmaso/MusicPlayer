package com.tim10011001.untitled.presenters;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

import com.tim10011001.untitled.data.models.Track;


/**
 * Created by tim10011001 on 4/18/17.
 */

public class Player implements PlayerInterface{

    private MediaPlayer player;
    private final String TAG = "PLAYER";
    private Uri currentUri = Uri.EMPTY;
    private static Player instance = null;

    private Player(){

    }

    public static Player getInstance(){
        if(instance == null)
        {
            instance = new Player();
        }

        return instance;
    }


    @Override
    public void next(Track track) {
        currentUri = track.getTrackUri();
    }

    @Override
    public void prev(Track track) {
        currentUri = track.getTrackUri();
    }

    @Override
    public void pause() {
        if(player == null) return;
        player.pause();
    }

    @Override
    public void play(Context context) {
        if(currentUri.equals(Uri.EMPTY)){
            Toast.makeText(context, "No tracks", Toast.LENGTH_LONG).show();
            return;
        }

        if(player == null){
            player = MediaPlayer.create(context, currentUri);
            player.prepareAsync();
            player.start();

        }else{
            Toast.makeText(context, "No tracks", Toast.LENGTH_LONG).show();
        }

    }
}
