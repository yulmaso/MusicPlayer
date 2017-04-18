package com.tim10011001.untitled;


import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tim10011001.untitled.ui.fragments.PlayerFragment;
import com.tim10011001.untitled.ui.pager.SlidePagerAdapter;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.support.v7.appcompat.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @BindView(R.id.main_pager) ViewPager mPager;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindDrawable(R.drawable.ic_menu_black_24dp) Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(drawable);
        SlidePagerAdapter adapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        if(mPager.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
