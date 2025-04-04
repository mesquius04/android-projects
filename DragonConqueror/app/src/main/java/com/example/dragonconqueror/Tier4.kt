package com.example.dragonconqueror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView

class Tier4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tier4)

        var image1d=findViewById<ImageButton>(R.id.imagebuttonbufffd)
        var image2d=findViewById<ImageButton>(R.id.imagebuttonbufff2d)
        var progressbar2d= findViewById<ProgressBar>(R.id.simpleProgressBard)
        var extraspeedd = findViewById<TextView>(R.id.tvVariableed)
        var stotaltime2d= String.format("%d", dragon200000*2500)
        extraspeedd.text= stotaltime2d
        if (four==0){
            progressbar2d.setProgress(dragon200000)
            if (progressbar2d.progress>=10){
                progressbar2d.max=100
                progressbar2d.setProgress(dragon200000-10)
                image1d.visibility= View.GONE
                image2d.visibility= View.VISIBLE
                four=1
            }
        }
        else if (four==1){
            image1d.visibility= View.GONE
            image2d.visibility= View.VISIBLE
            progressbar2d.max=100
            progressbar2d.setProgress(dragon200000-10)
            if (progressbar2d.progress==100){
                image2d.visibility= View.GONE
            }
        }
    }
}