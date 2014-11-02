package la.mejorando.sfotipy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import la.mejorando.sfotipy.R;
import la.mejorando.sfotipy.models.Song;

/**
 * Created by thespianartist on 25/09/14.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> implements RatingBar.OnRatingBarChangeListener{

    ArrayList<Song> songs;
    int itemLayout;


    public SongsAdapter(ArrayList<Song> songs,int itemLayout ){
        this.itemLayout = itemLayout;
        this.songs = songs;
    }


    @Override
    public SongsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       // View v = viewGroup;

       // if (v == null) {
        View    v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout, viewGroup, false);
       // }

        // Set the view to the ViewHolder
        ViewHolder holder = new ViewHolder(v);
        holder.stars.setOnRatingBarChangeListener(this);

        //holder.stars.setTag(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(SongsAdapter.ViewHolder viewHolder, int i) {
        ViewHolder holder = viewHolder;

        Song song = songs.get(i);

        viewHolder.namesong.setText(song.getSongName());
        viewHolder.artist.setText(song.getSongArtist());
        viewHolder.stars.setNumStars(3);
        viewHolder.stars.setTag(i);
        viewHolder.stars.setRating(songs.get(i).getStars());

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView namesong;
        TextView artist ;
        RatingBar stars;


        public ViewHolder(View itemView) {
            super(itemView);

         namesong = (TextView) itemView.findViewById(R.id.name_song);
         artist  = (TextView) itemView.findViewById(R.id.artist);
         stars = (RatingBar) itemView.findViewById(R.id.ratingBar);


        }

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        int position = (Integer) ratingBar.getTag();
        songs.get(position).setStars(rating);
       // ratingBar.setRating(songs.get(i).getStars());

    }
}
