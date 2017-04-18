package com.tim10011001.untitled.presenters;

import android.content.Context;

import com.tim10011001.untitled.data.models.Track;

/**
 * Created by tim10011001 on 4/18/17.
 */

public interface PlayerInterface {
    void next(Track track);
    void prev(Track track);
    void pause();
    void play(Context context);

}
