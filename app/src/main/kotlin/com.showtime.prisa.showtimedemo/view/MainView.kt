package com.showtime.prisa.showtimedemo.view

import android.media.Image
import com.showtime.prisa.showtimedemo.model.MovieList
import retrofit.RetrofitError


/**
 * Created by Admin on 5/7/15.
 */
public interface  MainView {
    fun setWatchList()
    fun setMovieListAdapter(movies: MovieList)
}