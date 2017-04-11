package com.tim10011001.untitled.models;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.tim10011001.untitled.R;

import java.util.Locale;

/**
 * Created by tim10011001 on 3/31/17.
 */

public class Track {
    private static long id;
    private String name;
    private String duration;

    public Track(String name, String duration){
        id++;
        this.name = name;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "TRACK(id: %d, name: %s, duration: %s", id, name, duration);
    }
}
