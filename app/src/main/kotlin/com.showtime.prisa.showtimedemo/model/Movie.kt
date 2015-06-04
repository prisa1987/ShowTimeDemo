package com.showtime.prisa.showtimedemo.model

import com.google.gson.annotations.SerializedName
import kotlin.properties.Delegates

/**
 * Created by Admin on 5/28/15.
 */
public class Movie {
    public var id:Int? = 0
    public var title:String? = null
    public var poster_path:String? = null
    public var overview:String? = null

    @SerializedName("vote_average")
    public var rating:Float? = 0f

    @SerializedName("vote_count")
    public var voteCount:Int? = 0
}