package com.showtime.prisa.showtimedemo.network.api


import com.showtime.prisa.showtimedemo.model.MovieList
import retrofit.Callback
import retrofit.http.GET


/**
 * Created by Admin on 5/24/15.
 */
public interface  MovieRetrofit {
    GET("/discover/movie?api_key=f904112e20a1649edbee609afe1b4752")
    fun getMovieList(callback : Callback<MovieList>)
}