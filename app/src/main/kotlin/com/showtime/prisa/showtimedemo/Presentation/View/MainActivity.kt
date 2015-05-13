package com.showtime.prisa.showtimedemo.Presentation.View

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.os.StrictMode
import android.support.v4.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import com.showtime.prisa.showtimedemo.Presentation.View.MainView
import com.showtime.prisa.showtimedemo.Presentation.Presenter.MainPresenter
import com.showtime.prisa.showtimedemo.Presentation.Presenter.MainPresenterImpl
import com.showtime.prisa.showtimedemo.R
import java.net.URL
import kotlin.properties.Delegates

/**
 * MainActivity : View of WatchList ,Show title,poster
 */
public class MainActivity : AppCompatActivity(), MainView {

    var titleView: TextView by Delegates.notNull()
    var posterView: ImageView by Delegates.notNull()
    var movieLayout: RelativeLayout by Delegates.notNull()

    val presenter: MainPresenter by Delegates.lazy {
        MainPresenterImpl(this)
    }

    val mainLayout: RelativeLayout by Delegates.lazy {
        findViewById(R.id.mainLayout) as RelativeLayout
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        val policy: StrictMode.ThreadPolicy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContentView(R.layout.activity_watch_list_)
        setWatchList()
    }

    override fun showWatchList(colCount:Int,rowCount:Int,id:Int,colSpan:Int) {
        val blockLayoutParam: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        if(colCount == 0)
            blockLayoutParam.addRule(RelativeLayout.ALIGN_PARENT_START)
        else
            blockLayoutParam.addRule(RelativeLayout.RIGHT_OF,id-1)
        if(rowCount != 0)
            blockLayoutParam.addRule(RelativeLayout.BELOW, id-colSpan)


        movieLayout.addView(posterView)
        movieLayout.addView(titleView)
//        mainLayout.removeAllViews()
        mainLayout.addView(movieLayout,blockLayoutParam)

    }

    override fun setWatchList() {
        Log.d("Call Presenter: ", "MainPresenter")
        presenter.setWatchList()

    }

    override fun setTitle(title: String,id:Int) {
        titleView = TextView(this)
        titleView.setId(id)
        titleView.setText(title)
        val titleLayoutParam: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(300,300)
        if(id >0) titleLayoutParam.addRule(RelativeLayout.RIGHT_OF,id-1)
        titleView.setLayoutParams(titleLayoutParam)
        Log.d("Set Title : ", title)
    }

    override fun setPoster(posterImgURI:String,id:Int) {
        posterView = ImageView(this)
        val url:URL = URL("http://image.tmdb.org/t/p/w300/$posterImgURI")
        val bmp: Bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        val posterLayoutParam: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        posterView.setLayoutParams(posterLayoutParam)
        posterView.setImageBitmap(bmp)
        Log.d("Set Poster","Poster")
    }

    override fun setBlockLayout(id:Int){
        movieLayout = RelativeLayout(this)
        movieLayout.setId(id)
        Log.d("Set Movie Layout ID : ", id.toString())
    }

}