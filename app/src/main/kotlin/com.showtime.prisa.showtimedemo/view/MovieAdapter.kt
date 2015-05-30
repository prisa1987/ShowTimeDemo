package com.showtime.prisa.showtimedemo.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.showtime.prisa.showtimedemo.R
import com.showtime.prisa.showtimedemo.model.MovieList
import com.squareup.picasso.Picasso
import java.net.URI
import java.net.URL


import kotlin.properties.Delegates

/**
 * Created by Admin on 5/28/15.
 */
public class MovieAdapter (context: Context,movies: MovieList) : BaseAdapter(){

    val context = context
    val movies = movies

    override fun getCount(): Int {
        return movies.results!!.size()
    }

    override fun getItem(position: Int): Any? {
        return movies.results!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
       var view:View
       var mInflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
       if(convertView == null){
            view = mInflater.inflate(R.layout.row_grid,parent,false)
       }else  view = convertView

        val titleView:TextView = view.findViewById(R.id.item_text) as TextView
        titleView.setText( movies.results!!.get(position)!!.title)
        val posterView:ImageView = view.findViewById(R.id.item_image) as ImageView
        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w300/${movies.results!!.get(position).poster_path}")
                .into(posterView)

        return view
    }

}