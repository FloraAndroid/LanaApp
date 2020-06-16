package com.archeticture.flora.lanaapp.motion.viewmodel
import android.content.Context
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.motion.model.HeaderItem
import com.archeticture.flora.lanaapp.motion.model.MotionDataView
import com.archeticture.flora.lanaapp.motion.model.MotionItem

class MotionViewModel(): ViewModel() {


    val motionDataLive=MutableLiveData<MotionDataView>()

    //todo integrate with firebase
    fun getMotionData(context: Context){
        val headerItem=HeaderItem()
        headerItem.img= BitmapFactory.decodeResource(context.getResources(), R.drawable.general_nails)
        headerItem.description="Create Your own Attitude"
        headerItem.title="Nail is your first "
        val list=ArrayList<MotionItem>()
        for (i in 0..88){
            list.add(
                MotionItem("$i",
                    "name $i",
                    "date $i",null)
            )
        }
        val motionDataView=MotionDataView(headerItem,list)
        motionDataLive.postValue(motionDataView)

    }


}