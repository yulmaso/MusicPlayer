package com.tim10011001.untitled.ui.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tim10011001.untitled.ui.fragments.ListFragment;
import com.tim10011001.untitled.ui.fragments.PlayerFragment;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class SlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int COUNTER = 2;

    public SlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PlayerFragment();
            case 1:
                return new ListFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return COUNTER;
    }
}
