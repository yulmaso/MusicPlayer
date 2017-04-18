package com.tim10011001.untitled.data.models;

import android.net.Uri;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class Track {
    private static int id = 0;
    private Uri trackUri;
    private String name;
    private String album;
    private String author;
    private String duration;


    public Track(String name, String album, String author, String duration, Uri trackUri){
        id++;
        this.name = name;
        this.album = album;
        this.author = author;
        this.duration = duration;
        this.trackUri = trackUri;
    }

    public Uri getTrackUri() {
        return trackUri;
    }

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }

    public String getAuthor() {
        return author;
    }

    public String getDuration() {
        return duration;
    }
}
