package com.example.androidanimations

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Animator.AnimatorListener {
   /* private var rotateAnimator: Animator? = null
    private var translateAnimator: Animator? = null
    private var scaleAnimator: Animator? = null
    private var fadeAnimator: Animator? = null*/

    private var rotateAnimator: ObjectAnimator? = null
    private var translateAnimator: ObjectAnimator? = null
    private var scaleAnimator: ObjectAnimator? = null
    private var fadeAnimator: ObjectAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun rotateAnimation(view: View) {

        //rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator = ObjectAnimator.ofFloat(targetImage, "rotation", 0.0f, -180.0f)
        rotateAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }
        //rotateAnimator.addListener(this@MainActivity)
    }

    fun scaleAnimation(view: View) {

        //scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimator = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 3.0f)
        scaleAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }

    }

    fun translateAnimation(view: View) {

        //translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator = ObjectAnimator.ofFloat(targetImage, "translationX", 0f, 200f)
        translateAnimator?.apply {
            duration = 1000
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }


    }

    fun fadeAnimation(view: View) {

        //fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha)
        fadeAnimator = ObjectAnimator.ofFloat(targetImage, "alpha", 1.0f, 0.0f)
        fadeAnimator?.apply {
            duration = 1500
            repeatCount = 1
            repeatMode = ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }

        //fadeAnimator.setTarget(targetImage)
        //fadeAnimator.start()
    }


    override fun onAnimationStart(animation: Animator?) {
        if(animation == scaleAnimator)
            Toast.makeText(this, "Scale Animation Started", Toast.LENGTH_SHORT).show()
        if(animation == rotateAnimator)
            Toast.makeText(this, "Rotate Animation Started", Toast.LENGTH_SHORT).show()
        if(animation == translateAnimator)
            Toast.makeText(this, "Translate Animation Started", Toast.LENGTH_SHORT).show()
        if (animation == fadeAnimator)
            Toast.makeText(this, "Fade Animation Started", Toast.LENGTH_SHORT).show()
    }
    override fun onAnimationRepeat(animation: Animator?) {
        Toast.makeText(this, "Animation Repeat", Toast.LENGTH_SHORT).show()

    }

    override fun onAnimationEnd(animation: Animator?) {
        Toast.makeText(this, "Animation End", Toast.LENGTH_SHORT).show()

    }

    override fun onAnimationCancel(animation: Animator?) {
        Toast.makeText(this, "Animation Cancelled", Toast.LENGTH_SHORT).show()

    }

    fun setFromXML(view: View) {

        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(targetImage)
            start()
        }
    }

    fun setFromCode(view: View) {
        // Root Animator Set
        val rootSet = AnimatorSet()

        // Flip Animation
        val flip = ObjectAnimator.ofFloat(targetImage, "rotationX", 0.0f, 360.0f)
        flip.duration = 500

        // Child Animator Set
        val childSet = AnimatorSet()

        // Scale Animations
        val scaleX = ObjectAnimator.ofFloat(targetImage, "scaleX", 1.0f, 1.5f)
        scaleX.duration = 500
        scaleX.interpolator = OvershootInterpolator()

        val scaleY = ObjectAnimator.ofFloat(targetImage, "scaleY", 1.0f, 1.5f)
        scaleY.duration = 500
        scaleY.interpolator = OvershootInterpolator()

        //rootSet.playSequentially(flip, childSet)
        //childSet.playTogether(scaleX, scaleY)

        rootSet.play(flip).before(childSet)
        childSet.play(scaleX).with(scaleY)

        rootSet.start()
    }

    fun viewPropertyAnimator(view: View){
       val vpa : ViewPropertyAnimator =  targetImage.animate()
        vpa.apply {
            duration = 1000
            rotationX(360.0f)
            scaleX(1.5f)
            scaleY(1.5f)
            //remove
            translationX(200.0f)
            alpha(0.5f)
            //remove end
            interpolator = OvershootInterpolator()
            start()
        }
    }

    fun propertyValuesHolder(view: View){
        val rotX: PropertyValuesHolder = PropertyValuesHolder.ofFloat("rotationX", 360f)
        val scaX: PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX", 1.5f)
        val scaY: PropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleY", 1.5f)

        val objA: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(targetImage, rotX, scaX, scaY)

        objA.apply {
            duration = 1000
            interpolator = OvershootInterpolator()
            start() 
        }
    }







}
