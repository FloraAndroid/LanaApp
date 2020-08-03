package com.archeticture.flora.lanaapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.archeticture.flora.lanaapp.motion.MotionListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.JELLY_BEAN){
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.startActivity(Intent(this,
            MotionListActivity::class.java))
    }
}
