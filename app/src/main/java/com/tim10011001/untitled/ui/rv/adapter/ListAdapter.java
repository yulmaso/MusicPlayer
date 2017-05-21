package com.tim10011001.untitled.ui.rv.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
import com.tim10011001.untitled.interfaces.PlayerBinder;
import com.tim10011001.untitled.interfaces.TrackNavigator;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by tim10011001 on 4/18/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TrackHolder> {

    private static List<Track> tracks;
    private static int position = 0;
    private static PlayerBinder binder;

    public ListAdapter(List<Track> tracks, PlayerBinder binder)
    {
        ListAdapter.binder = binder;
        ListAdapter.tracks = tracks;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public TrackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_holder, parent, false);

        return new TrackHolder(layout);
    }

    @Override
    public void onBindViewHolder(TrackHolder holder, int position) {
        Track currentTrack = tracks.get(position);
        if(currentTrack.getAlbumArt() != null){
            holder.album.setImageBitmap(currentTrack.getAlbumArt());
        }else{
            holder.album.setImageDrawable(holder.unknown);
        }
        holder.name.setText(currentTrack.getName());
        holder.artist.setText(currentTrack.getAuthor());

        int length = Integer.parseInt(currentTrack.getDuration()) / 1000;

        int seconds = length % 60;
        int minutes = length / 60;
        holder.duration.setText(String.format(Locale.ENGLISH, "%d:%d", minutes, seconds));
        Log.d("Info", "onBindViewHolder " + position);
    }

    public void setTrack(int position){
        binder.setTrack(tracks.get(position));
    }


    public int getPosition(){
        return position;
    }
    public void setPosition(int position) {ListAdapter.position = position;}

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    static class TrackHolder extends RecyclerView.ViewHolder{
        ImageView album;
        TextView artist;
        TextView name;
        TextView duration;
        Drawable unknown;


        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        TrackHolder(final View itemView)
        {
            super(itemView);
            album = (ImageView) itemView.findViewById(R.id.album_photo);
            artist = (TextView) itemView.findViewById(R.id.artist);
            name = (TextView) itemView.findViewById(R.id.track_name);
            duration = (TextView) itemView.findViewById(R.id.track_time);
            unknown = itemView.getResources().getDrawable(R.drawable.albums);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binder.setTrack(tracks.get(getAdapterPosition()));
                    position = getAdapterPosition();
                }
            });
        }

    }
}
