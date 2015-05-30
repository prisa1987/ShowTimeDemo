package com.showtime.prisa.showtimedemo.View

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.os.StrictMode
import android.support.v4.app.ActionBarDrawerToggle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.*

import com.showtime.prisa.showtimedemo.R
import com.showtime.prisa.showtimedemo.model.MovieList
import com.showtime.prisa.showtimedemo.presenter.MainPresenter
import com.showtime.prisa.showtimedemo.presenter.MainPresenterImpl
import com.showtime.prisa.showtimedemo.view.MainView
import com.showtime.prisa.showtimedemo.view.MovieAdapter
import retrofit.RetrofitError
import java.net.URL
import kotlin.properties.Delegates

/**
 * MainActivity : View of WatchList ,Show title,poster
 */

public class MainActivity : ActionBarActivity(), MainView, ActionBar.TabListener {

    var mGridView : GridView by Delegates.notNull()
    val presenter: MainPresenter by Delegates.lazy {
        MainPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR)
        super<ActionBarActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watchlist)
        val actionBar : ActionBar = getSupportActionBar()
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS)

        val tabWatchList:ActionBar.Tab = actionBar.newTab()
                .setText("Watch List")
                .setTabListener(this)
        val tabTopRated:ActionBar.Tab = actionBar.newTab()
                .setText("Watch List")
                .setTabListener(this)
        val tabNowPlaying:ActionBar.Tab = actionBar.newTab()
                .setText("Now Playing")
                .setTabListener(this)

        actionBar.addTab(tabWatchList)
        actionBar.addTab(tabTopRated)
        actionBar.addTab(tabNowPlaying)



        mGridView = findViewById(R.id.gridView) as GridView
        setWatchList()
    }

    override fun setMovieListAdapter(movies: MovieList) {
        mGridView.setAdapter(MovieAdapter(this@MainActivity, movies))
    }

    fun setWatchList() {
        Log.d("Call Presenter: ", "MainPresenter")
        presenter.setWatchList()
    }

    /* Tab */
    override fun onTabSelected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {

    }

    override fun onTabUnselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {

    }

    override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {

    }




}