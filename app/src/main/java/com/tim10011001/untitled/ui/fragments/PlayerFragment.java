package com.tim10011001.untitled.ui.fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.tim10011001.untitled.R;
import com.tim10011001.untitled.data.models.Track;
import com.tim10011001.untitled.interfaces.PlayerBinder;
import com.tim10011001.untitled.interfaces.TrackNavigator;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class PlayerFragment extends Fragment implements PlayerBinder, SeekBar.OnSeekBarChangeListener {

    private Unbinder unbinder;
    private MediaPlayer player;
    private Handler handler = new Handler();
    private Uri nUri;
    private TrackNavigator navigator;
    //private Uri oUri;
    @BindView(R.id.play) ImageButton play;
    @BindView(R.id.pause) ImageButton pause;
    @BindView(R.id.next) ImageButton next;
    @BindView(R.id.previous) ImageButton previous;
    @BindView(R.id.track_progress) SeekBar progress;
    @BindView(R.id.track_title) TextView title;
    @BindView(R.id.album_view) ImageView albumView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.player_layout, container, false);
        unbinder = ButterKnife.bind(this, layout);

        playAndUpdate.run();

        progress.setOnSeekBarChangeListener(this);
        playAndUpdate.run();

        //player = MediaPlayer.create(this.getContext(), oUri);

        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        player.release();
        unbinder.unbind();
    }

    @Override
    public void onStop() {
        super.onStop();
        player.release();
        player = null;
    }

    @OnClick(R.id.next)
    public void onNextPressed(){
        navigator.next();
    }

    @OnClick(R.id.previous)
    public void onPreviousPressed(){
        navigator.previous();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.play)
    public void onPlayPressed(){
        play.setVisibility(View.GONE);
        pause.setVisibility(View.VISIBLE);

        if(player == null){
            player = MediaPlayer.create(this.getContext(), nUri);
            //oUri = nUri;
        }

        progress.setMax(player.getDuration() / 1000);
        Log.d("Duration", String.valueOf(player.getDuration()));
        player.start();
    }

    @OnClick(R.id.pause)
    public void onPausePressed(){
        pause.setVisibility(View.GONE);
        play.setVisibility(View.VISIBLE);
        player.pause();

    }

    private Runnable playAndUpdate = new Runnable() {
        @Override
        public void run() {
            if(player != null && player.isPlaying()){
                int currentPosition = player.getCurrentPosition() / 1000;
                progress.setProgress(currentPosition);
            }
            handler.postDelayed(this, 1000);
        }
    };


    @Override
    public void setTrack(Track track) {
        if(player != null){
            player.release();
            player = null;
        }

        this.nUri = track.getTrackUri();
        title.setText(String.format("%s - %s", track.getAuthor(), track.getName()));
        albumView.setImageBitmap(track.getAlbumArt());
        pause.setVisibility(View.GONE);
        play.setVisibility(View.VISIBLE);
    }

    public void setTrackNavigator(TrackNavigator navigator){
        this.navigator = navigator;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser) {
            player.seekTo(progress * 1000);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
