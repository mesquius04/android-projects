package com.nihoi.communitywar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ActivityFirst : AppCompatActivity() {
    private lateinit var btnLog:ImageView
    private lateinit var btnReg:ImageView
    private lateinit var btnAboutus:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initVars()
        initListeners()
    }
    fun initVars(){
        btnLog=findViewById(R.id.ivlogin)
        btnReg=findViewById(R.id.ivregister)
        btnAboutus=findViewById(R.id.ivaboutus)
    }
    fun initListeners(){
        btnLog.setOnClickListener{
            val intent = Intent(this, ActivityLog::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        btnAboutus.setOnClickListener{
            val intent = Intent(this, ActivityAboutUs::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        btnReg.setOnClickListener{
            val intent = Intent(this, ActivityRegister::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

    }
}