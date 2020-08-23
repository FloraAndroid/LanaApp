package com.archeticture.flora.lanaapp.motion

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.motion.ui.main.SectionsPagerAdapter
import com.archeticture.flora.lanaapp.motion.viewmodel.MotionViewModel

class TabbedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tabbed_activity)
        val motionViewModel: MotionViewModel =
            ViewModelProvider(this).get(MotionViewModel::class.java)
        val sectionsPagerAdapter= SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }
}