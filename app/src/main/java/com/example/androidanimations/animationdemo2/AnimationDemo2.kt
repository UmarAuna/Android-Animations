package com.example.androidanimations.animationdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidanimations.R
import com.sriyank.animationsdemo.Landscape
import com.sriyank.animationsdemo.RecyclerAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator
import kotlinx.android.synthetic.main.activity_animation_demo2.*

class AnimationDemo2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_demo2)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        val adapter = RecyclerAdapter(this, Landscape.data)
        recyclerView.adapter = ScaleInAnimationAdapter(adapter)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager

        recyclerView.itemAnimator = OvershootInRightAnimator()
        recyclerView.itemAnimator?.apply {
            addDuration = 500 // duration of add operation
            removeDuration = 500 // duration of delete operation
        }
    }
}
