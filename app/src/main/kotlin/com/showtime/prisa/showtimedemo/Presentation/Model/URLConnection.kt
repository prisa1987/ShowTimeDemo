package com.showtime.prisa.showtimedemo.Presentation.Model

import android.util.Log
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.ResponseHandler
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.DefaultHttpClient
import java.net.URI
import kotlin.properties.Delegates

/**
 * Connect to MovieDB
 */
public class URLConnection {



    //Creating HTTP Client and HTTP Get
    val client: HttpClient = DefaultHttpClient()
    val httpGet: HttpGet = HttpGet("")

    //Set URI
    fun setURI(url:String) {
        var uri: URI = URI(url)
        httpGet.setURI(uri)
    }


    //Making HTTP Request
    fun getResponseBody(): String {
        try{
            val resonse: HttpResponse = client.execute(httpGet)
            val responseHandler: ResponseHandler<String> = BasicResponseHandler()
            val responseBody:String = responseHandler.handleResponse(resonse)
            Log.d("Http Response:", resonse.getStatusLine().getStatusCode().toString())
            return responseBody
        }catch(e:Exception){
            return "Error"
        }
    }

}