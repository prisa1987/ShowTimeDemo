package com.showtime.prisa.showtimedemo.view

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import com.showtime.prisa.showtimedemo.R
import com.showtime.prisa.showtimedemo.model.Movie
import com.showtime.prisa.showtimedemo.presenter.MovieDetailPresenter
import com.showtime.prisa.showtimedemo.presenter.MovieDetailPresenterImpl
import kotlin.properties.Delegates

/**
 * Created by Admin on 6/4/15.
 */
public class MovieDetailActivity : AppCompatActivity(),MovieDetailView {

    var movieID:Int by Delegates.notNull()

    val presenter: MovieDetailPresenter by Delegates.lazy {
        MovieDetailPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        val bundle:Bundle = getIntent().getExtras()

        if(bundle != null){
            movieID =  bundle.getInt("movieID")
        }
        setContentView(R.layout.activity_moviedetail)
        setMovieInfo()
    }


    override  fun setMovieInfo() {
        Log.d("Call Presenter: ", "MovieDetail")
        presenter.setMovieInfo(movieID)
    }

    override fun setDetail(detail: String) {
        val detailTextView:TextView = findViewById(R.id.movieDetail) as TextView
        detailTextView.setText(detail)
    }

    override fun setTitle(title: String) {
        val titleTextView:TextView = findViewById(R.id.movieTitle) as TextView
        titleTextView.setText(title)
    }

    override fun setVideo(uri: Uri) {
        val mediaController:MediaController = MediaController(this@MovieDetailActivity)
        val videoView:VideoView = findViewById(R.id.movieVideo) as VideoView
//        videoView.setMediaController(mediaController)
//        videoView.setVideoURI(uri)
//        videoView.requestFocus()

    }

    override fun setRating(rating: Float) {

    }


    override fun setVoteNumber(count: Int) {

    }





}