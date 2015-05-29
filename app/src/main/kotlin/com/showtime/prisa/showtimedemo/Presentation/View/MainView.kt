package com.showtime.prisa.showtimedemo.view

import android.media.Image
import com.showtime.prisa.showtimedemo.model.MovieList


/**
 * Created by Admin on 5/7/15.
 */
public trait MainView {
    fun setMovieListAdapter(movies: MovieList)
}