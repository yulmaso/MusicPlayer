package com.tim10011001.untitled.ui.rv.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tim10011001.untitled.R;
import com.tim10011001.untitled.data.models.Track;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TrackHolder> {

    private List<Track> tracks;

    private Unbinder unbinder;
    @BindView(R.id.album_photo) ImageView album;
    @BindView(R.id.track_name) TextView name;
    @BindView(R.id.track_time) TextView duration;
    @BindView(R.id.cv)  CardView cv;
    @BindDrawable(R.drawable.ic_album_black_24dp) Drawable unknow;

    public ListAdapter(List<Track> tracks){
        this.tracks = tracks;
    }

    @Override
    public TrackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_holder, parent, false);

        unbinder = ButterKnife.bind(this, layout);

        return new TrackHolder(layout);
    }

    @Override
    public void onBindViewHolder(TrackHolder holder, int position) {
        Track currentTrack = tracks.get(position);
        album.setImageDrawable(unknow);
        name.setText(currentTrack.getName());
        duration.setText(currentTrack.getDuration());
        Log.d("Info", "onBindViewHolder " + position);

    }



    @Override
    public int getItemCount() {
        return tracks.size();
    }

    static class TrackHolder extends RecyclerView.ViewHolder{

        TrackHolder(View itemView) {
            super(itemView);
        }
    }
}
