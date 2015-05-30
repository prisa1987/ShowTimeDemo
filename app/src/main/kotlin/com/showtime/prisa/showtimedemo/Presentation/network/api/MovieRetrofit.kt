package com.showtime.prisa.showtimedemo.network.api

import com.showtime.prisa.showtimedemo.model.Movie
import com.showtime.prisa.showtimedemo.model.MovieList
import retrofit.Callback
import retrofit.http.GET


/**
 * Created by Admin on 5/24/15.
 */
public trait MovieRetrofit {
    GET("/discover/movie?api_key=f904112e20a1649edbee609afe1b4752")
    fun getMovieList(callback : Callback<MovieList>)
}