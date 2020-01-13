package com.example.androidanimations

import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.androidanimations.animationdemo1.AnimationDemo1
import com.example.androidanimations.animationdemo2.AnimationDemo2
import com.example.androidanimations.animationdemo3.AnimationDemo3
import kotlinx.android.synthetic.main.activity_list_activiy.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_activiy)
        val projects = arrayOf(
            "Basic Animation",
            "Battery Animation",
            "AnimatedVectorDrawable",
            "Transition Example 1",
            "Transition Example 2",
            "Animation Demo 1",
            "Animation Demo 2",
            "Animation Demo 3"
        )

        val arrayAdapter = ArrayAdapter(this@ListActivity, android.R.layout.simple_list_item_1, projects)

        listview.adapter = arrayAdapter

        listview.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> startActivity(Intent(this@ListActivity, MainActivity::class.java))
                1 -> startActivity(Intent(this@ListActivity, Main2Activity::class.java))
                2 -> startActivity(Intent(this@ListActivity, Main3Activity::class.java))
                3 -> startActivity(Intent(this@ListActivity, TransitionExample1::class.java))
                4 -> startActivity(Intent(this@ListActivity, TransitionExample2::class.java))
                5 -> startActivity(Intent(this@ListActivity, AnimationDemo1::class.java))
                6 -> startActivity(Intent(this@ListActivity, AnimationDemo2::class.java))
                7 -> startActivity(Intent(this@ListActivity, AnimationDemo3::class.java))

            }
        }

    }
}
