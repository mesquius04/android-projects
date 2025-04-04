package com.example.dragonconqueror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.animation.ObjectAnimator
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class Tier1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tier1)
        var image1=findViewById<ImageButton>(R.id.imagebuttonbufff)
        var image2=findViewById<ImageButton>(R.id.imagebuttonbufff2)
        var progressbar= findViewById<ProgressBar>(R.id.simpleProgressBar)
        var extraspeed = findViewById<TextView>(R.id.tvVariablee)
        var stotaltime2= String.format("%d", dragon1200*10)
        var image3=findViewById<ImageButton>(R.id.imagebuttonbufff3)
        var image4=findViewById<ImageButton>(R.id.imagebuttonbufff4)
        extraspeed.text= stotaltime2
        if (first==0){
            progressbar.setProgress(dragon1200)
            if (progressbar.progress>=10){
                progressbar.max=100
                progressbar.setProgress(dragon1200-10)
                image1.visibility= View.GONE
                image2.visibility=View.VISIBLE
                first=1
            }
        }
        else if (first==1){
            image1.visibility= View.GONE
            image2.visibility=View.VISIBLE
            progressbar.max=100
            progressbar.setProgress(dragon1200-10)
            if (progressbar.progress==100){
                image3.visibility=View.VISIBLE
                progressbar.max=1000
                first=2
            }
        }
        else if (first==2){
            image2.visibility=View.VISIBLE
            image3.visibility=View.VISIBLE
            progressbar.max=1000
            progressbar.setProgress(dragon1200-110)
            if (progressbar.progress==1000){
                image4.visibility=View.VISIBLE
                first=3
            }
        }
        else if (first==3){
            image2.visibility=View.VISIBLE
            image3.visibility=View.VISIBLE
            image4.visibility=View.VISIBLE
            progressbar.visibility=View.GONE
        }
    }
}