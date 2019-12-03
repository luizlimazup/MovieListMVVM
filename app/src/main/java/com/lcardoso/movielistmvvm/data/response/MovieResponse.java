package com.lcardoso.movielistmvvm.data.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.lcardoso.movielistmvvm.data.model.MovieResults;

import java.util.List;

public class MovieResponse implements Parcelable {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private List<MovieResults> movieResults;

    public MovieResponse() {
    }

    public MovieResponse(int page, int totalResults, int totalPages, List<MovieResults> movieResults) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.movieResults = movieResults;
    }

    protected MovieResponse(Parcel in) {
        page = in.readInt();
        totalResults = in.readInt();
        totalPages = in.readInt();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(totalResults);
        dest.writeInt(totalPages);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<MovieResults> getMovieResults() {
        return movieResults;
    }

    public void setMovieResults(List<MovieResults> movieResults) {
        this.movieResults = movieResults;
    }
}
