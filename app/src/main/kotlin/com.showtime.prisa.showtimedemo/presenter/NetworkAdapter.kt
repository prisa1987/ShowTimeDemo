package com.showtime.prisa.showtimedemo.presenter

import com.showtime.prisa.showtimedemo.network.api.MovieRetrofit
import retrofit.RestAdapter
import kotlin.properties.Delegates

/**
 * Created by Admin on 6/4/15.
 */
public abstract class  NetworkAdapter() {

        var retrofit:Any by Delegates.notNull()

        //create an adapter for retrofit with base url
        val restAdapter: RestAdapter = RestAdapter.Builder()
                .setEndpoint("http://api.themoviedb.org/3")
                .build()

        fun setRetrofit(classRetrofit:Class<Any>){
            retrofit = restAdapter.create(classRetrofit)
        }

}