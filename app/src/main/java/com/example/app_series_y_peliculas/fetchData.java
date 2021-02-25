package com.example.app_series_y_peliculas;

import android.graphics.Movie;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_series_y_peliculas.Botons_Fragment.Fragment_Buscar;
import com.example.app_series_y_peliculas.RecyclerViews.ListAdapter;
import com.example.app_series_y_peliculas.RecyclerViews.PeliculaSerie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class fetchData extends AsyncTask<Void, Void, Void> {

    protected String data = "";
    protected String results = "";
    protected ArrayList<String> strTypes; // Create an ArrayList object
    protected String movie;

    protected FragmentActivity fr;

    public fetchData(String movie, FragmentActivity fr) {

        this.movie = movie;
        this.fr = fr;

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {

            //Make API connection
            URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=dc5c546bfdaef9a6da9e082c1e2ef636&query=" + movie.replaceAll(" ", "+"));
            Log.i("logTest", "https://api.themoviedb.org/3/search/movie?api_key=dc5c546bfdaef9a6da9e082c1e2ef636&query=" + movie.replaceAll(" ", "+"));

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // Read API results
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sBuilder = new StringBuilder();

            // Build JSON String
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }

            inputStream.close();
            data = sBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        JSONObject jObject = null;
        try {
            jObject = new JSONObject(data);

            List<PeliculaSerie> elements = new ArrayList<>();


            JSONArray results = new JSONArray(jObject.getString("results"));
            for (int i = 0; i < results.length(); i++){
                JSONObject movie = new JSONObject(results.getString(i));
                String title = movie.getString("title");
                String popularity = movie.getString("popularity");
               // Log.i("logTest", title);

                JSONArray genre_id = new JSONArray(movie.getString("genre_ids"));
                for (int j = 0; j < genre_id.length(); j++){

                    Log.i("logTest", String.valueOf(genre_id.getString(j)));

                }

                elements.add(new PeliculaSerie("#000000", title, "No Visto",popularity));

            }



            ListAdapter listAdapter = new ListAdapter(elements, fr);
            RecyclerView recyclerView = fr.findViewById(R.id.lista_recyclerview);

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(fr));
            recyclerView.setAdapter(listAdapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
