package com.example.dragonconqueror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView

class Tier3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tier3)

        var image1c=findViewById<ImageButton>(R.id.imagebuttonbufffc)
        var image2c=findViewById<ImageButton>(R.id.imagebuttonbufff2c)
        var progressbar2c= findViewById<ProgressBar>(R.id.simpleProgressBarc)
        var extraspeedc = findViewById<TextView>(R.id.tvVariableec)
        var stotaltime2c= String.format("%d", dragon25000*300)
        extraspeedc.text= stotaltime2c
        if (third==0){
            progressbar2c.setProgress(dragon25000)
            if (progressbar2c.progress>=10){
                progressbar2c.max=100
                progressbar2c.setProgress(dragon25000-10)
                image1c.visibility= View.GONE
                image2c.visibility= View.VISIBLE
                third=1
            }
        }
        else if (third==1){
            image1c.visibility= View.GONE
            image2c.visibility= View.VISIBLE
            progressbar2c.max=100
            progressbar2c.setProgress(dragon25000-10)
            if (progressbar2c.progress==100){
                image2c.visibility= View.GONE
            }
        }
    }
}