package com.example.dragonconqueror

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class Shop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        val score=findViewById<TextView>(R.id.tvVariablef)
        val fustarandom = findViewById<ImageButton>(R.id.imageSHOP1)
        val rarerandom = findViewById<ImageButton>(R.id.imageSHOPb)
        val goldenrandom=findViewById<ImageButton>(R.id.imageSHOPc)
        val Dragon1200 = findViewById<ImageButton>(R.id.imageSHOP4)
        val Dragon5000 = findViewById<ImageButton>(R.id.imageSHOP5)
        val Dragon25000 = findViewById<ImageButton>(R.id.imageSHOP6)
        val Dragon200000 = findViewById<ImageButton>(R.id.imageSHOP7)
        val Dragon10000000 = findViewById<ImageButton>(R.id.imageSHOP8)
        var actuals=actualscore.toString()
        score.text=actuals
        fustarandom.setOnClickListener{
            if (actualscore>=4000){
                actualscore-=4000
                actuals=actualscore.toString()
                val random= Random()
                val randomNumber=random.nextInt(10000)+1
                if (randomNumber<=6500){
                    dragon1200++
                    totaltime+=10
                    score.text=actuals
                }
                else if (randomNumber<=9500){
                    dragon5000++
                    totaltime+=50
                    score.text=actuals
                }
                else if (randomNumber<10000){
                    dragon25000++
                    totaltime+=300
                    score.text=actuals
                }
                else{
                    dragon200000++
                    totaltime+=2500
                    score.text=actuals
                }
            }
        }
        rarerandom.setOnClickListener{
            if (actualscore>=20000){
                actualscore-=20000
                actuals=actualscore.toString()
                val random2= Random()
                val randomNumber2=random2.nextInt(10000)+1
                if (randomNumber2<=500){
                    dragon1200++
                    totaltime+=10
                    score.text=actuals
                }
                else if (randomNumber2<=4500){
                    dragon5000++
                    totaltime+=50
                    score.text=actuals
                }
                else if (randomNumber2<=9200){
                    dragon25000++
                    totaltime+=300
                    score.text=actuals
                }
                else{
                    dragon200000++
                    totaltime+=2500
                    score.text=actuals
                }
            }

        }
        goldenrandom.setOnClickListener{
            if (actualscore>=300000){
                actualscore-=300000
                actuals=actualscore.toString()
                val random3= Random()
                val randomNumber3=random3.nextInt(10000)+1
                if (randomNumber3<=300){
                    dragon5000++
                    totaltime+=50
                    score.text=actuals
                }
                else if (randomNumber3<=4000){
                    dragon25000++
                    totaltime+=300
                    score.text=actuals
                }
                else if(randomNumber3<=9970){
                    dragon200000++
                    totaltime+=2500
                    score.text=actuals
                }
                else{
                    dragon10000000++
                    totaltime+=150000
                    score.text=actuals
                }
            }

        }
        Dragon1200.setOnClickListener {
            if (actualscore>=1200){
                dragon1200++
                actualscore-=1200
                actuals=actualscore.toString()
                totaltime+=10
                score.text=actuals
            }
        }
        Dragon5000.setOnClickListener{
            if (actualscore>=5000){
                dragon5000++
                actualscore-=5000
                actuals=actualscore.toString()
                totaltime+=50
                score.text=actuals
            }
        }
        Dragon25000.setOnClickListener {
            if (actualscore>=25000){
                dragon25000++
                actualscore-=25000
                actuals=actualscore.toString()
                totaltime+=300
                score.text=actuals
            }
        }
        Dragon200000.setOnClickListener {
            if (actualscore>=200000){
                dragon200000++
                actualscore-=200000
                actuals=actualscore.toString()
                totaltime+=2500
                score.text=actuals
            }
        }
        Dragon10000000.setOnClickListener {
            if (actualscore>=10000000){
                dragon10000000++
                actualscore-=10000000
                actuals=actualscore.toString()
                totaltime+=150000
                score.text=actuals
            }
        }
    }
}