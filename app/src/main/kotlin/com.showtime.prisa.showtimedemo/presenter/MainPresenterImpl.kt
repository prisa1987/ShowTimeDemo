package com.showtime.prisa.showtimedemo.presenter

import android.content.Context
import android.graphics.Point
import android.util.Log
import android.view.Display
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast
import com.showtime.prisa.showtimedemo.model.MovieList
import com.showtime.prisa.showtimedemo.network.api.MovieRetrofit
import com.showtime.prisa.showtimedemo.view.MainView
import retrofit.Callback
import retrofit.RestAdapter
import retrofit.RetrofitError
import retrofit.client.Response
import java.util.ArrayList
import java.util.HashMap

/**
 * MainPresentImp : Update each component in MainActivity
 */
public class MainPresenterImpl(mainView: MainView):MainPresenter , NetworkAdapter() {

    val mainView = mainView

    override fun onResume() {
        setWatchList()
    }

    override fun setWatchList() {
        val retrofit: MovieRetrofit = restAdapter.create(javaClass<MovieRetrofit>())
        retrofit.getMovieList(callBackMovieList())
    }

    inner public class callBackMovieList:Callback<MovieList>{
        override fun success(movies: MovieList, response: Response?) {
            mainView.setMovieListAdapter(movies)
            Log.d("Response Body: ","${movies.results}")
        }

        override fun failure(error: RetrofitError) {
            Log.d("Response Fail: ","${error}")
        }
    }

}