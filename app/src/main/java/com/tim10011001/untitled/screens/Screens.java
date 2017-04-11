package com.tim10011001.untitled.screens;

import com.tim10011001.untitled.R;

/**
 * Created by tim10011001 on 3/31/17.
 */

public class Screens {
    private static int[] screens = {R.layout.player_layout, R.layout.list_layout};

    public static int getRes(int position){
        if(position > screens.length){
            return 0;
        }else {
            return screens[position];
        }
    }

    public static int getLength(){
        return screens.length;
    }
}
