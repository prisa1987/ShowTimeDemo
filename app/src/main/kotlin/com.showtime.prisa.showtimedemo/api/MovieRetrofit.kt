package com.showtime.prisa.showtimedemo.network.api


import com.showtime.prisa.showtimedemo.model.Movie
import com.showtime.prisa.showtimedemo.model.MovieList
import com.showtime.prisa.showtimedemo.model.TrailerList
import retrofit.Callback
import retrofit.http.GET
import retrofit.http.Path


/**
 * Created by Admin on 5/24/15.
 */
public interface  MovieRetrofit {
    GET("/discover/movie?api_key=f904112e20a1649edbee609afe1b4752")
    fun getMovieList(callback : Callback<MovieList>)

    GET("/movie/{id}?api_key=f904112e20a1649edbee609afe1b4752")
    fun getMovie( Path("id")  id:Int,callback : Callback<Movie>)

    GET("/movie/{id}/videos?api_key=f904112e20a1649edbee609afe1b4752")
    fun getTrailer( Path("id")  id:Int,callback : Callback<TrailerList> )


}