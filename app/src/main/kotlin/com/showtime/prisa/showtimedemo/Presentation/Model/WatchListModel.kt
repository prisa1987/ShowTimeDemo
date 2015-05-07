package com.showtime.prisa.showtimedemo.Presentation.Model

import android.util.Log
import java.util.ArrayList
import java.util.HashMap

/**
 * Manage about watchList Info Logic
 */
public class WatchListModel {
    var watchListURL:URLConnection = URLConnection()
    var watchListResult:JsonManagement = JsonManagement()
    var titleList:ArrayList<String> = ArrayList<String>()
    val posterMap: HashMap<String, String> = HashMap<String, String>()

    fun setWatchInfo(){
        //Connect to MovieDB
        watchListURL.setURI("http://api.themoviedb.org/3/discover/movie?api_key=f904112e20a1649edbee609afe1b4752")
        val response:String = watchListURL.getResponseBody()

        //Get discover movie
        watchListResult.setDiscoverMovieInfo(response)
        var watchListInfo = watchListResult.getDiscoverMovieInfo()
        for( i in 0.. watchListInfo.size()-1 ){
            titleList.add(watchListInfo.get(i).get("original_title"))
            posterMap.put(watchListInfo.get(i).get("original_title"),watchListInfo.get(i).get("poster_path"))
        }
        Log.d("Poster Map",posterMap.toString())
    }

    fun getTitle():ArrayList<String>{
        return titleList
    }

    fun getImage(): HashMap<String, String> {
        return posterMap
    }


}