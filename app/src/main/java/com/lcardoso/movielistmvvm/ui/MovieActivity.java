package com.lcardoso.movielistmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.lcardoso.movielistmvvm.R;

public class MovieActivity extends AppCompatActivity {

    MovieViewModel movieViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);

        getListMovie();
        recyclerView = findViewById(R.id.rvMovie);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void getListMovie() {
        movieViewModel.getmMovieResponseLiveData().observe(this, movieResponse -> {
            if (movieResponse != null) {

                MovieAdapter movieAdapter = new MovieAdapter(movieResponse.getMovieResults());
                recyclerView.setAdapter(movieAdapter);

//                Log.d("RESPONSE", "getListMovie: " + movieResponse.getMovieResults().get(0).getTitle());
//                Log.d("RESPONSE", "getListMovie: " + movieResponse.getMovieResults().get(1).getTitle());
//                Log.d("RESPONSE", "getListMovie: " + movieResponse.getMovieResults().get(2).getTitle());
//                Log.d("RESPONSE", "getListMovie: " + movieResponse.getMovieResults().get(3).getTitle());
//                Log.d("RESPONSE", "getListMovie: " + movieResponse.getMovieResults().get(4).getTitle());
//                Log.d("RESPONSE", "getListMovie: " + movieResponse.getMovieResults().get(5).getTitle());
            }

        });
    }
}
