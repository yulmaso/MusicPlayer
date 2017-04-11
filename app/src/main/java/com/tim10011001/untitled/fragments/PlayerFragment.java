package com.tim10011001.untitled.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.tim10011001.untitled.R;
import com.tim10011001.untitled.listeners.PlayerEventListener;

/**
 * Created by tim10011001 on 3/24/17.
 */

public class PlayerFragment extends Fragment {

    private MediaPlayer player;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.player_layout, container, false);
        PlayerEventListener eventListener = new PlayerEventListener();
        ImageButton start = (ImageButton) layout.findViewById(R.id.play);
        ImageButton pause = (ImageButton) layout.findViewById(R.id.pause);
        start.setOnClickListener(eventListener);
        pause.setOnClickListener(eventListener);

        return layout;
    }

}
