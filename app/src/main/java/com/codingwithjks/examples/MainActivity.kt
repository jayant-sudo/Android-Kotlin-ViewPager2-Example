package com.codingwithjks.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.codingwithjks.examples.Adapter.ViewPagerAdapter
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {
  private lateinit var layouts:ArrayList<Int>
  private lateinit var viewPagerAdapter: ViewPagerAdapter
  private lateinit var viewPager2:ViewPager2
    private lateinit var layoutdots:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        layouts= arrayListOf(
            R.layout.activity_food,
            R.layout.activity_movie,
            R.layout.activity_discount
        )
        layoutdots=findViewById(R.id.layoutDots)
        viewPager2=findViewById(R.id.viewpager)
        viewPagerAdapter= ViewPagerAdapter(this,layouts)
        viewPager2.adapter=viewPagerAdapter
        //viewPager2.registerOnPageChangeCallback()

        val btnSkip:Button=findViewById(R.id.btn_skip)
        btnSkip.setOnClickListener {

        }
        val btnNext:Button=findViewById(R.id.btn_next)
        btnNext.setOnClickListener {
            var current=getItem(+1)
            if(current < layouts.size){
                viewPager2.currentItem = current
            }
        }
    }


   private fun getItem(position:Int):Int{
       return viewPager2.currentItem + position
   }
}