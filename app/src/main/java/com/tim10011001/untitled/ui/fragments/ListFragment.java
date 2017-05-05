package com.tim10011001.untitled.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tim10011001.untitled.R;
import com.tim10011001.untitled.data.models.Track;
import com.tim10011001.untitled.ui.rv.adapter.ListAdapter;
import com.tim10011001.untitled.utils.TrackGenerator;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class ListFragment extends Fragment {

    private Unbinder unbinder;
    @BindView(R.id.recycler_view) RecyclerView rv;
    private RecyclerView.LayoutManager manager;
    private ListAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.list_layout, container, false);
        unbinder = ButterKnife.bind(this, layout);
        manager = new LinearLayoutManager(container != null ? container.getContext() : null);
        adapter = new ListAdapter(TrackGenerator.generateTenTracks());

        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
