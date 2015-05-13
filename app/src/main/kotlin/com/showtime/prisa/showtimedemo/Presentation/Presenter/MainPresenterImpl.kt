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
 * MainPresentImp : Update each component in MainActivity
 */
public class MainPresenterImpl(mainView: MainView):MainPresenter {

    val mainView = mainView
    override fun onResume() {
        setWatchList()
    }

    override fun setWatchList() {
        val watchListModel: WatchListModel = WatchListModel()
        watchListModel.setWatchInfo()
        val titleList:ArrayList<String> = watchListModel.getTitle()
        val posterList:HashMap<String,String> = watchListModel.getImage()
        var colCount = 0
        var rowCount = 0
        var colSpan = 3


        for( i in titleList.indices){
            val title = titleList[i]
            val posterURL = posterList[title]
            mainView.setTitle(title,i+1)
            mainView.setPoster(posterURL,i+1)
            mainView.setBlockLayout(i+1)
            mainView.showWatchList(colCount,rowCount,i+1,colSpan)

            if(colCount == colSpan-1) rowCount +=  1
            colCount = (colCount + 1) % colSpan
        }

    }

}