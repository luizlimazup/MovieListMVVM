package com.lcardoso.movielistmvvm.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lcardoso.movielistmvvm.R;
import com.lcardoso.movielistmvvm.data.model.MovieResults;
import com.lcardoso.movielistmvvm.util.Constants;
import com.lcardoso.movielistmvvm.util.ImageUtils;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<MovieResults> mMovieResults;

    public MovieAdapter(List<MovieResults> movieResults) {
        this.mMovieResults = movieResults;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        holder.bind(mMovieResults.get(position));
}

    @Override
    public int getItemCount() {
        return (mMovieResults != null && mMovieResults.size() > 0) ? mMovieResults.size() : 0;
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private ProgressBar progressBar;
        private TextView textView;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageMovie);
            progressBar = itemView.findViewById(R.id.pbMovie);
            textView = itemView.findViewById(R.id.textTitle);
        }

        public void bind(MovieResults movieResults){

            textView.setText(movieResults.getTitle());
            ImageUtils.loadImage(Constants.IMAGE_URL + movieResults.getPosterPath(), imageView,
                    progressBar, R.drawable.ic_launcher_foreground);
        }
    }
}
