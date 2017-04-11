package com.tim10011001.untitled.utils;

import com.tim10011001.untitled.models.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tim10011001 on 3/31/17.
 */

public class TrackGenerator {
    public static List<Track> generate(){
        List<Track> list = new ArrayList<>();
        String[] names = {"Gorillaz", "Martin Garrix", "50 Cent"};
        String[] durations = {"2:38", "5:16", "3:30"};
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            list.add(new Track(names[random.nextInt(names.length)],
                                durations[random.nextInt(durations.length)]));
        }

        return list;
    }
}
