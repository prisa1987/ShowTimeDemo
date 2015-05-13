package com.showtime.prisa.showtimedemo.Presentation.Model

import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList
import java.util.HashMap

/**
 * Manage Json format that get from responseBody
 */
public class JsonManagement {
    val watchList: ArrayList<HashMap<String, String>> = ArrayList<HashMap<String, String>>()

    fun setDiscoverMovieInfo(responseBody:String){
        Log.d("Response : ",responseBody)
        val data: JSONObject = JSONObject(responseBody)
        val resultsOBJ =  data.getString("results")
        val results: JSONArray = JSONArray(resultsOBJ)

        for( i in 0..results.length()-1){
            val map: HashMap<String, String> = HashMap<String, String>()
            val jsonObj: JSONObject = results.getJSONObject(i)
            map.put("id",jsonObj.getString("id"))
            map.put("original_title",jsonObj.getString("original_title"))
            map.put("poster_path",jsonObj.getString("poster_path"))
            watchList.add(map)
        }

    }

    fun getDiscoverMovieInfo(): ArrayList<HashMap<String, String>> {
        return watchList
    }

}