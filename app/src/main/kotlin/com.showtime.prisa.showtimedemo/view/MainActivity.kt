package com.showtime.prisa.showtimedemo.view

import android.app.FragmentTransaction
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.os.StrictMode
import android.support.v4.app
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.showtime.prisa.showtimedemo.model.Movie
import com.showtime.prisa.showtimedemo.presenter.MainPresenter
import com.showtime.prisa.showtimedemo.presenter.MainPresenterImpl
import com.showtime.prisa.showtimedemo.R
import com.showtime.prisa.showtimedemo.model.MovieList
import retrofit.RetrofitError
import kotlin.properties.Delegates

/**
 * MainActivity : View of WatchList ,Show title,poster
 */
public class MainActivity: AppCompatActivity(), MainView , ActionBar.TabListener {

    var mRecyclerView: RecyclerView by Delegates.notNull()
    var mLayoutManager: GridLayoutManager by Delegates.notNull()

    val presenter: MainPresenter by Delegates.lazy {
          MainPresenterImpl(this)
      }

      override fun onCreate(savedInstanceState: Bundle?) {
          getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
          super<AppCompatActivity>.onCreate(savedInstanceState)
          setContentView(R.layout.activity_watchlist)
          val actionBar: ActionBar = getSupportActionBar()
          actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS)

          val tabNowPlaying:ActionBar.Tab = actionBar.newTab()
                  .setText("Now Playing")
                  .setTabListener(this)
          val tabTopRated:ActionBar.Tab = actionBar.newTab()
                  .setText("Top rated")
                  .setTabListener(this)

          actionBar.addTab(tabTopRated)
          actionBar.addTab(tabNowPlaying)

          mRecyclerView = findViewById(R.id.movieRecyclerView) as RecyclerView
          mLayoutManager = GridLayoutManager(mRecyclerView.getContext(),3)
          mRecyclerView.setHasFixedSize(true)
          mRecyclerView.setLayoutManager(mLayoutManager)

          setWatchList()
      }


      override fun setMovieListAdapter(movies: MovieList) {
          val movieAdapter: MovieAdapter = MovieAdapter(this,movies)
          mRecyclerView.setAdapter(movieAdapter)
      }

      override fun setWatchList() {
        Log.d("Call Presenter: ", "MainPresenter")
        presenter.setWatchList()
      }



    /* Tab */
    override fun onTabSelected(tab: ActionBar.Tab?, ft: app.FragmentTransaction?) {

    }

    override fun onTabUnselected(tab: ActionBar.Tab?, ft: app.FragmentTransaction?) {

    }

    override fun onTabReselected(tab: ActionBar.Tab?, ft: app.FragmentTransaction?) {

    }




}