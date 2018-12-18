package com.pedromassango.delyo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setupNavigationDrawer()
    }

    private fun setupNavigationDrawer() {
        val drawerToggle = object: ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close){
            val scaleFactor = 5F

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = (drawerView.width * slideOffset)
                content.translationX = slideX
                content.scaleX = (1 - slideOffset/scaleFactor)
                content.scaleY = (1 - slideOffset/scaleFactor)
            }

            override fun onDrawerOpened(drawerView: View) {
                content.setBackgroundResource(R.drawable.rounded_corners)
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                content.setBackgroundResource(R.drawable.rounded_corners_default)
                super.onDrawerClosed(drawerView)
            }
        }

        // attach the drawer listener to our drawer layout
        drawer_layout.setScrimColor(Color.TRANSPARENT)
        drawer_layout.drawerElevation = 0F
        drawer_layout.addDrawerListener(drawerToggle)
        toolbar.setNavigationOnClickListener { drawer_layout.openDrawer(GravityCompat.START) }

    }
}
