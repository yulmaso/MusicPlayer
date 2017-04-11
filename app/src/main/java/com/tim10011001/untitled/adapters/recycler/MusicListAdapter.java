package com.tim10011001.untitled.adapters.recycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tim10011001.untitled.R;
import com.tim10011001.untitled.models.Track;

import java.util.List;

/**
 * Created by tim10011001 on 3/30/17.
 */

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MusicViewHolder> {

    private List<Track> trackList;

    public MusicListAdapter(List<Track> tracks){
        this.trackList = tracks;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_holder, parent);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        Track currentTrack = trackList.get(position);
        holder.nameView.setText(currentTrack.getName());
        holder.durationView.setText(currentTrack.getDuration());
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    class MusicViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView albumView;
        TextView nameView;
        TextView durationView;

        public MusicViewHolder(View itemView) {
            super(itemView);

            cv = (CardView) itemView.findViewById(R.id.cv);
            albumView = (ImageView) itemView.findViewById(R.id.album_photo);
            nameView = (TextView) itemView.findViewById(R.id.track_name);
            durationView = (TextView) itemView.findViewById(R.id.track_time);
        }
    }
}
