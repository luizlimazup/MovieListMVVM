package com.lcardoso.movielistmvvm.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.lcardoso.movielistmvvm.data.response.MovieResponse;
import com.lcardoso.movielistmvvm.util.Constants;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository mMovieRepository;
    private LiveData<MovieResponse> mMovieResponseLiveData;

    public MovieViewModel(@NonNull Application application) {
        super(application);

        mMovieRepository = new MovieRepository();
        this.mMovieResponseLiveData = mMovieRepository. getMovie(Constants.API_KEY, "pt-BR");
    }

    public LiveData<MovieResponse> getmMovieResponseLiveData(){
        return mMovieResponseLiveData;
    }
}
