package com.showtime.prisa.showtimedemo.view

import android.net.Uri
import com.showtime.prisa.showtimedemo.model.Movie

/**
 * Created by Admin on 6/4/15.
 */
public interface  MovieDetailView {
    fun setMovieInfo()
    fun setVideo(uri: Uri)
    fun setTitle(title:String)
    fun setDetail(Detail:String)
    fun setRating(rating:Float)
    fun setVoteNumber(count:Int)

}