package com.showtime.prisa.showtimedemo.Presentation.View

import android.media.Image

/**
 * Created by Admin on 5/7/15.
 */
public trait MainView {
    fun setWatchList()
    fun showWatchList(colCount:Int,rowCount:Int,id:Int,colSpan:Int)
    fun setTitle(title:String,id:Int)
    fun setPoster(posterImgURI:String,id:Int)
    fun setBlockLayout(id:Int)

}