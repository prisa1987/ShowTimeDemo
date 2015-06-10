package com.showtime.prisa.showtimedemo.view

import android.content.Context
import android.support.v7.widget.RecyclerView
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
public class MovieAdapter (context: Context,movies: MovieList) : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    var movieList:MovieList = movies
    var mContext:Context = context

    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){

        var  titleView:TextView  =  view.findViewById(R.id.item_text) as TextView
        var posterView:ImageView  =  view.findViewById(R.id.item_image) as ImageView

    }

    // Create new views (invoked by the layout manager)
    override fun getItemCount(): Int {
       return movieList!!.results!!.size()
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.titleView!!.setText(movieList!!.results!!.get(position)!!.title)
        Picasso.with(mContext)
                .load("http://image.tmdb.org/t/p/w300/${movieList!!.results!!.get(position).poster_path}")
                .into(holder.posterView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        // create a new view
        val mInflater:LayoutInflater = parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View = mInflater.inflate(R.layout.row_grid,parent,false)
        // set the view's size, margins, paddings and layout parameters
        val viewHolder:ViewHolder = ViewHolder(view)
        return viewHolder
    }


}