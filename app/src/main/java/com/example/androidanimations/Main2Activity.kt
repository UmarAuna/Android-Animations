package com.example.androidanimations

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    lateinit var batteryAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


    }

    override fun onStart() {
        super.onStart()
        targetImage2.setBackgroundResource(R.drawable.battery_animation_list)
        batteryAnimation = targetImage2.background as AnimationDrawable
        batteryAnimation.start()
    }

    fun startStopAnimation(view: View){
        if(batteryAnimation.isRunning){
            batteryAnimation.stop()
        }else{
            batteryAnimation.start()
        }
    }
}