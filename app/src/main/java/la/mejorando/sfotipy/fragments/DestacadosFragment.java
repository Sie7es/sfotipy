package la.mejorando.sfotipy.fragments;



import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;

import la.mejorando.sfotipy.R;
import la.mejorando.sfotipy.adapters.SongsAdapter;
import la.mejorando.sfotipy.models.Song;

/**
 * A simple {@link android.app.Fragment} subclass.
 *
 */
public class DestacadosFragment extends Fragment {


    ArrayList<Song> dataset;
    private Button myButton;
    private SongsAdapter adapter;
    ArrayList<Song> songs;

    public DestacadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_destacados, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

         songs = new ArrayList<Song>();


        myButton = (Button) getActivity().findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Song song = new Song();
                song.setSongArtist("Nuevo");
                song.setSongName("Nombre");
                song.setStars(0);
                songs.add(song);*/

                adapter.notifyItemMoved(0, 1);
                Collections.swap(songs, 0, 1);
            }
        });

        String URL = "https://script.google.com/macros/s/AKfycbxYMVeK_mfrW0vZs7z6BsrHLSuFcB8H4L7bcYaoqo4AumyXOdw/exec";

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(),"Espere por favor","estamos atendiendo su solocitud");

        JsonArrayRequest req = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.e("mirespuesta",response.toString());
                dataset = new ArrayList<Song>();
                dataset= parser(response);

                progressDialog.cancel();

            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();

            }
        });



        queue.add(req);


        Song song  = new Song();
        song.setStars(3);
        song.setSongName("GerLucky");
        song.setSongArtist("DaftPunk");
        songs.add(song);


        Song song3  = new Song();
        song3.setStars(3);
        song3.setSongName("GerLucky");
        song3.setSongArtist("DaftPunk");
        songs.add(song3);

        Song song4  = new Song();
        song4.setStars(3);
        song4.setSongName("GerLucky");
        song4.setSongArtist("DaftPunk");
        songs.add(song4);


        Song song6  = new Song();
        song6.setStars(3);
        song6.setSongName("GerLucky");
        song6.setSongArtist("DaftPunk");
        songs.add(song6);

        Song song7  = new Song();
        song7.setStars(3);
        song7.setSongName("GerLucky");
        song7.setSongArtist("DaftPunk");
        songs.add(song7);

        Song song8 = new Song();
        song8.setStars(3);
        song8.setSongName("GerLucky");
        song8.setSongArtist("DaftPunk");
        songs.add(song8);



        Song song9  = new Song();
        song9.setStars(3);
        song9.setSongName("GerLucky");
        song9.setSongArtist("DaftPunk");
        songs.add(song9);


        Song song10  = new Song();
        song10.setStars(3);
        song10.setSongName("GerLucky");
        song10.setSongArtist("DaftPunk");
        songs.add(song10);



        Song song11  = new Song();
        song11.setStars(3);
        song11.setSongName("GerLucky");
        song11.setSongArtist("DaftPunk");
        songs.add(song11);



        Song song12 = new Song();
        song12.setStars(3);
        song12.setSongName("GerLucky");
        song12.setSongArtist("DaftPunk");
        songs.add(song12);



        Song song13  = new Song();
        song13.setStars(3);
        song13.setSongName("GerLucky");
        song13.setSongArtist("DaftPunk");
        songs.add(song13);
       /* for (int cont = 0; cont < 20; cont++) {
            Song song2 = new Song();
            song2.setStars(3);
            song2.setSongName("GerLucky");
            song2.setSongArtist("DaftPunk");
            songs.add(song2);
        }*/

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_song);
        recyclerView.setHasFixedSize(true);
        adapter = new SongsAdapter(songs, R.layout.row_songs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }


    public ArrayList<Song> parser (JSONArray response){

        ArrayList<Song> songsAux = new ArrayList<Song>();

        for(int i = 0; i<response.length(); i++){

            Song song = new Song();

            try {

                JSONObject jsonObject = (JSONObject) response.get(i);

                song.setSongName(jsonObject.getString("cancion"));
                song.setSongArtist(jsonObject.getString("artista"));
                song.setStars(jsonObject.getInt("estrellas"));

                Log.e("dato",song.getSongName().toString());

               songsAux.add(song);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


        return songsAux;
    }

}
