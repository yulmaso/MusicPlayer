package com.tim10011001.untitled.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.tim10011001.untitled.R;
import com.tim10011001.untitled.adapters.recycler.MusicListAdapter;
import com.tim10011001.untitled.utils.TrackGenerator;

/**
 * Created by tim10011001 on 3/24/17.
 */

public class MusicListFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MusicListAdapter musicListAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.list_layout, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(container != null ? container.getContext() : null);
        musicListAdapter = new MusicListAdapter(TrackGenerator.generate());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(musicListAdapter);
        return layout;
    }
}
