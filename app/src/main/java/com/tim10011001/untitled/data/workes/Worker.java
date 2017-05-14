package com.tim10011001.untitled.data.workes;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.tim10011001.untitled.data.models.Track;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by tim10011001 on 5/7/17.
 */

public class Worker {
    private static Worker instance = null;
    private static File sdRoot = Environment.getExternalStorageDirectory();
    private static File root = Environment.getRootDirectory();
    private final static List<URI> tracksUri = new ArrayList<>();
    private Context context;
    private Worker(Context context) {
        this.context = context;
    }

    public static Worker getInstance(Context context) {
        if(instance == null) instance = new Worker(context);

        return instance;
    }

    public File getRoot(){
        return sdRoot;
    }

    public void findTracks(){
        File file = new File(sdRoot, "Music");
        for(File f: file.listFiles()){
            if(f.getAbsolutePath().endsWith(".mp3")) tracksUri.add(f.toURI());
            Log.d("Music", f.getAbsolutePath());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public List<Track> getTracks(){
        List<Track> tracks = new ArrayList<>();

        for(URI uri: tracksUri){
            Uri mUri = Uri.parse(uri.toString());
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            retriever.setDataSource(context, mUri);
            String name = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            name = (name == null) ? "<Unknown>" : name;
            String album = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
            album = (album == null) ? "<Unknown>" : album;
            String author = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            author = (author == null) ? "<Unknown>" : author;
            String duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            duration = (duration == null) ? "<Unknown>" : duration;


            byte[] art = retriever.getEmbeddedPicture();
            Bitmap albumArt = null;
            if(art != null){
                albumArt = BitmapFactory.decodeByteArray(art, 0, art.length);
            }

            Track track = new Track(name, album, author, duration, mUri, albumArt);
            tracks.add(track);
            Log.d("WORKER", track.toString());
        }

        return tracks;
    }
}
