package com.tim10011001.untitled.utils;

import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;

import com.tim10011001.untitled.data.models.Track;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class TrackGenerator {

    private static List<String> paths = new ArrayList<>();
    private static String[] names = {"Candy shop" , "On Melancholy Hill", "Blacker the Berry", "Phoenix"};
    private static String[] durations = {"2:10", "1:58", "6:13", "8:43"};
    private static String[] albums = {"First", "Second", "Third", "Fourth" };
    private static String[] authors = {"50 Cent", "Gorillaz", "Green day", "Kendrick Lamar"};

    public static List<Track> generateTenTracks(){
        Random random = new Random();
        List<Track> tracks = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Track track = new Track(
                    names[random.nextInt(4)],
                    albums[random.nextInt(4)],
                    authors[random.nextInt(4)],
                    durations[random.nextInt(4)],
                    Uri.EMPTY
            );

            tracks.add(track);
        }

        return tracks;
    }

    public static List<String> getPaths(){
        return paths;
    }

    public static void walk(File root){

        File[] files = root.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                Log.d("Dir", f.getAbsolutePath());
                walk(f);
            }else{
                Log.d("File", f.getAbsolutePath());
            }
        }




    }
}
