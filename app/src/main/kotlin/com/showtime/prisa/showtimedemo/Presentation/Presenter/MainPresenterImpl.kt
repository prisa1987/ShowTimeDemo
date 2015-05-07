package com.showtime.prisa.showtimedemo.Presentation.Presenter

import android.content.Context
import android.graphics.Point
import android.util.Log
import android.view.Display
import android.view.WindowManager
import android.widget.RelativeLayout
import com.showtime.prisa.showtimedemo.Presentation.Model.WatchListModel
import com.showtime.prisa.showtimedemo.Presentation.View.MainView
import com.showtime.prisa.showtimedemo.R
import java.util.ArrayList
import java.util.HashMap

/**
 * Created by Admin on 5/7/15.
 */
public class MainPresenterImpl(mainView: MainView):MainPresenter {

    val mainView = mainView
    override fun onResume() {
        setWatchList()
    }

    override fun setWatchList() {
        var watchListModel: WatchListModel = WatchListModel()
        watchListModel.setWatchInfo()
        var titleList:ArrayList<String> = watchListModel.getTitle()
        var posterList:HashMap<String,String> = watchListModel.getImage()
        var colCount = 0
        var rowCount = 0
        var colSpan = 3


        for( i in 0..titleList.size()-1){
//            Log.d("Title ",posterList.toString())
            var posterURL = posterList.get(titleList.get(i))
            mainView.setTitle(titleList.get(i),i+1)
            mainView.setPoster(posterURL,i+1)
            mainView.setBlockLayout(i+1)
            mainView.showWatchList(colCount,rowCount,i+1,colSpan)

            if(colCount == colSpan-1) rowCount +=  1
            colCount = (colCount + 1) % colSpan
        }

    }

}