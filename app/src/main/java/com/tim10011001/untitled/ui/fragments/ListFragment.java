package com.tim10011001.untitled.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
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
import com.tim10011001.untitled.data.workes.Worker;
import com.tim10011001.untitled.interfaces.PlayerBinder;
import com.tim10011001.untitled.interfaces.TrackNavigator;
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

public class ListFragment extends Fragment implements TrackNavigator {

    private Unbinder unbinder;
    @BindView(R.id.recycler_view) RecyclerView rv;
    private RecyclerView.LayoutManager manager;
    private ListAdapter adapter;
    private Worker worker;
    private PlayerBinder binder;
    private int current = 0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.list_layout, container, false);
        worker = Worker.getInstance(this.getContext());
        worker.findTracks();
        unbinder = ButterKnife.bind(this, layout);
        manager = new LinearLayoutManager(container != null ? container.getContext() : null);
        adapter = new ListAdapter(worker.getTracks(), binder);

        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);

        if(adapter.getItemCount() != 0){
            adapter.setTrack(current);
        }

        return layout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setBinder(PlayerBinder playerBinder){
        binder = playerBinder;
    }

    @Override
    public void next() {
        if(current < adapter.getItemCount() - 1){
            current++;
        }else{
            current = 0;
        }
        adapter.setTrack(current);
    }

    @Override
    public void previous() {
        if(current > 0){
            current--;
        }else{
            current = adapter.getItemCount() - 1;
        }
        adapter.setTrack(current);
    }
}
