package com.nihoi.communitywar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ActivityRank : AppCompatActivity() {
    private lateinit var back:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)
        initVars()
        initListeners()
    }
    fun initVars(){
        back=findViewById(R.id.backR)
    }
    fun initListeners(){
        back.setOnClickListener{
            val intent = Intent(this, ActivityGremi::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }
    }
}