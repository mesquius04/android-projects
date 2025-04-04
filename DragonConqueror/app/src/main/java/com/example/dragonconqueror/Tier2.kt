package com.example.dragonconqueror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView

class Tier2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tier2)

        var image1b=findViewById<ImageButton>(R.id.imagebuttonbufffb)
        var image2b=findViewById<ImageButton>(R.id.imagebuttonbufff2b)
        var progressbar2= findViewById<ProgressBar>(R.id.simpleProgressBarb)
        var extraspeedb = findViewById<TextView>(R.id.tvVariableeb)
        var stotaltime2b= String.format("%d", dragon5000*50)
        extraspeedb.text= stotaltime2b
        if (second==0){
            progressbar2.setProgress(dragon5000)
            if (progressbar2.progress>=10){
                progressbar2.max=100
                progressbar2.setProgress(dragon5000-10)
                image1b.visibility= View.GONE
                image2b.visibility= View.VISIBLE
                second=1
            }
        }
        else if (second==1){
            image1b.visibility= View.GONE
            image2b.visibility= View.VISIBLE
            progressbar2.max=100
            progressbar2.setProgress(dragon1200-10)
            if (progressbar2.progress==100){
                image2b.visibility= View.GONE
            }
        }
    }
}