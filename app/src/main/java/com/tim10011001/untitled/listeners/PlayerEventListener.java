package com.tim10011001.untitled.listeners;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.tim10011001.untitled.R;

/**
 * Created by tim10011001 on 3/30/17.
 */

public class PlayerEventListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        ViewGroup layout = (ViewGroup) v.getParent();
        ImageButton play = (ImageButton) layout.findViewById(R.id.play);
        ImageButton pause = (ImageButton) layout.findViewById(R.id.pause);
        switch (v.getId()){
            case R.id.play:
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                break;
            case R.id.pause:
                pause.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
        }
    }
}
