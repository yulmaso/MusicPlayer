package com.tim10011001.untitled.ui.fragments;

import android.media.MediaPlayer;
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

import android.widget.SeekBar;

import com.tim10011001.untitled.R;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class PlayerFragment extends Fragment {

    private Unbinder unbinder;
    private MediaPlayer player;
    private Handler handler = new Handler();
    @BindView(R.id.play) ImageButton play;
    @BindView(R.id.pause) ImageButton pause;
    @BindView(R.id.next) ImageButton next;
    @BindView(R.id.previous) ImageButton previous;
    @BindView(R.id.track_progress) SeekBar progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.player_layout, container, false);
        unbinder = ButterKnife.bind(this, layout);
        player = MediaPlayer.create(this.getContext(), R.raw.gorillaz);

        playAndUpdate.run();

        progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    player.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.play)
    public void onPlayPressed(){
        play.setVisibility(View.GONE);
        pause.setVisibility(View.VISIBLE);
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


}
