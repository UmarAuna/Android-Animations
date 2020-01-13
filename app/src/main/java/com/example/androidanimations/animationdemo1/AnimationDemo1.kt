package com.example.androidanimations.animationdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import com.example.androidanimations.R
import kotlinx.android.synthetic.main.activity_animation_demo1.*

class AnimationDemo1 : AppCompatActivity() {

    private var isDetailLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_demo1)

        constraintLayout.setOnClickListener {
            if (isDetailLayout)
            // switch to default layout
            swapFrames(R.layout.activity_animation_demo1)
            else
            // switch to detail layout
                swapFrames(R.layout.activity_animation_demo1_detail)
        }

    }

    private fun swapFrames(layoutId: Int){
        val constrainSet = ConstraintSet()
        constrainSet.clone(this, layoutId)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200


        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constrainSet.applyTo(constraintLayout)

        isDetailLayout = !isDetailLayout

    }
}
