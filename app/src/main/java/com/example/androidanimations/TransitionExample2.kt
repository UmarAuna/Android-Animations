package com.example.androidanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_transition_example2.*

class TransitionExample2 : AppCompatActivity() {

    private var visibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_example2)
    }

    fun fadeAnimation(view: View) {
        val transition = Fade()

        TransitionManager.beginDelayedTransition(sceneRoot, transition)
        txvDescription.visibility = if(visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility
    }

    fun slideEffect(view: View) {

        val transition = Slide(Gravity.END)
        TransitionManager.beginDelayedTransition(sceneRoot, transition)

        txvDescription.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility
    }
}
