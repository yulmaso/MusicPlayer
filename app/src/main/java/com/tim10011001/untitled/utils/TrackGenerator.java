package com.tim10011001.untitled.utils;

import android.net.Uri;

import com.tim10011001.untitled.data.models.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class TrackGenerator {

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
}
