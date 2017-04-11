package com.tim10011001.untitled.adapters.pagers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tim10011001.untitled.fragments.MusicListFragment;
import com.tim10011001.untitled.fragments.PlayerFragment;

/**
 * Created by tim10011001 on 3/24/17.
 */

public class CustomFragmentAdapter extends FragmentPagerAdapter {

    public CustomFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PlayerFragment();
            case 1:
                return new MusicListFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
