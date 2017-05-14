package com.tim10011001.untitled.data.models;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.util.Locale;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class Track {
    private static int id = 0;
    private Bitmap albumArt;
    private Uri trackUri;
    private String name;
    private String album;
    private String author;
    private String duration;

    public Track(String name, String album, String author, String duration, Uri trackUri, Bitmap art){
        id++;
        this.name = name;
        this.album = album;
        this.author = author;
        this.duration = duration;
        this.trackUri = trackUri;

        if(art != null){
            albumArt = art;
        }else{
            albumArt = null;
        }


    }


    public Bitmap getAlbumArt() {
        return albumArt;
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

    @Override
    public String toString(){
        return String.format(Locale.ENGLISH, "Track(%d: %s, %s, %s, %s, %s)", id, name, album, author, duration, trackUri);
    }
}
