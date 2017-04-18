package com.tim10011001.untitled.ui.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.tim10011001.untitled.R;
import com.tim10011001.untitled.presenters.Player;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class PlayerFragment extends Fragment {

    private Unbinder unbinder;
    private Player player;
    @BindView(R.id.play) ImageButton play;
    @BindView(R.id.pause) ImageButton pause;
    @BindView(R.id.next) ImageButton next;
    @BindView(R.id.previous) ImageButton previous;
    @BindView(R.id.track_progress) ProgressBar duration;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.player_layout, container, false);
        unbinder = ButterKnife.bind(this, layout);
        player = Player.getInstance();
        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.play)
    public void onPlayPressed(){
        play.setVisibility(View.GONE);
        pause.setVisibility(View.VISIBLE);
        player.play(this.getContext());
    }

    @OnClick(R.id.pause)
    public void onPausePressed(){
        pause.setVisibility(View.GONE);
        play.setVisibility(View.VISIBLE);
        player.pause();
    }


}
