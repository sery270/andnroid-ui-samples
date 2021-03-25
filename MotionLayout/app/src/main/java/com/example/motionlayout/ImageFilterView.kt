package com.example.motionlayout

import android.content.pm.ServiceInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.core.content.getSystemService
import androidx.core.os.HandlerCompat.postDelayed

class ImageFilterView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_filter_view)
    }
}