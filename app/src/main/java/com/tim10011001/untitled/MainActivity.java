package com.tim10011001.untitled;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.tim10011001.untitled.adapters.pagers.CustomFragmentAdapter;
public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        mPager = (ViewPager) findViewById(R.id.main_pager);
        mPager.setAdapter(new CustomFragmentAdapter(getSupportFragmentManager()));


    }
}
