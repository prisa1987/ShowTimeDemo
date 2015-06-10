package com.showtime.prisa.showtimedemo.presenter

import android.net.Uri
import android.util.Log
import android.widget.MediaController
import android.widget.Toast
import com.showtime.prisa.showtimedemo.model.Movie
import com.showtime.prisa.showtimedemo.model.Trailer
import com.showtime.prisa.showtimedemo.model.TrailerList
import com.showtime.prisa.showtimedemo.network.api.MovieRetrofit
import com.showtime.prisa.showtimedemo.view.MovieDetailView
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response
import kotlin.properties.Delegates

/**
 * Created by Admin on 6/4/15.
 */
public class MovieDetailPresenterImpl(movieDetailView: MovieDetailView) : MovieDetailPresenter,NetworkAdapter() {

    val movieDetailView = movieDetailView
    var uri:Uri by Delegates.notNull()

    override fun setMovieInfo(movieID: Int) {
       val retrofit:MovieRetrofit = restAdapter.create(javaClass<MovieRetrofit>())
        retrofit.getMovie(movieID,callBackMovie())
        retrofit.getTrailer(movieID,callBackTrailer())
    }

    inner public class callBackMovie: Callback<Movie> {
       override fun failure(error: RetrofitError?) {

       }

       override fun success(movie: Movie, response: Response?) {
           movieDetailView.setTitle(movie.title.toString())
           movieDetailView.setDetail(movie.overview.toString())
           movieDetailView.setRating(movie.rating!!.toFloat())
           movieDetailView.setVoteNumber(movie.voteCount!!.toInt())
       }
   }

    inner public class callBackTrailer: Callback<TrailerList>{
        override fun failure(error: RetrofitError?) {

        }

        override fun success(trailerList: TrailerList, response: Response?) {

            if(trailerList.results!!.size() > 0){
                var trailer: Trailer = trailerList.results!!.get(0)
                 Log.d("uri","http://${trailer.site!!.toLowerCase()}.com/watch?v=${trailer.key}")
                 uri = Uri.parse("http://${trailer.site!!.toLowerCase()}.com/watch?v=${trailer.key}")
                 movieDetailView.setVideo(uri)
            }
        }

    }
}