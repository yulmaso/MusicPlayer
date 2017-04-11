package com.tim10011001.untitled.adapters.pagers;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tim10011001.untitled.screens.Screens;

/**
 * Created by tim10011001 on 3/24/17.
 */

public class CustomPagerAdapter extends PagerAdapter {
    private Context context;

    public CustomPagerAdapter( Context context){
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int res = Screens.getRes(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(res, container, false);
        container.addView(viewGroup);
        return  viewGroup;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
       return Screens.getLength();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
