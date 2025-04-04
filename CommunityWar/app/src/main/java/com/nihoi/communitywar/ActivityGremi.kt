package com.nihoi.communitywar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import java.lang.Integer.max

class ActivityGremi : AppCompatActivity() {
    private lateinit var btnContr : ImageView
    private lateinit var btnContCL : ConstraintLayout
    private lateinit var tvScore : TextView
    private lateinit var tvNom: TextView
    private lateinit var btnRank : ImageView
    private lateinit var tvLvlPlant: TextView
    private lateinit var ivPlant: ImageView
    private lateinit var back: ImageView
    private lateinit var btnProf : ImageView
    private lateinit var currentPlayer:PlayersModel
    private lateinit var playerPref:PlayerPreferences
    private var todaysc=0
    private var daily=0
    private lateinit var nomG:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gremi)
        initVars()
        initListeners()
    }


    fun initVars(){
        playerPref=PlayerPreferences(this)
        currentPlayer=playerPref.getPlayerModel()!!
        daily=currentPlayer.daily
        todaysc=currentPlayer.totalsc
        nomG=currentPlayer.castleName
        btnContr=findViewById(R.id.ivCol)
        btnProf=findViewById(R.id.ivPerfil)
        tvScore=findViewById(R.id.tvScore)
        tvNom=findViewById(R.id.textView5)
        tvLvlPlant=findViewById(R.id.tvLvlPlant)
        ivPlant=findViewById(R.id.ivForm)
        btnRank=findViewById(R.id.ivrank)
        btnContCL=findViewById(R.id.ivColCL)
        tvScore.text=(max(3-daily,0)).toString()+"/3"
        tvNom.text=nomG
        tvLvlPlant.text=currentPlayer.playerName
        back=findViewById(R.id.backG)
        when (todaysc){
            in 0..1->{}
            in 1..3->{ivPlant.setPadding(8,18,8,8)
                tvLvlPlant.setText("2")}
            in 4..5->{ivPlant.setPadding(4,12,4,4)
                tvLvlPlant.setText("3")}
            in 5..8->{ivPlant.setPadding(2,3,2,2)
                tvLvlPlant.setText("4")}
            else->{ivPlant.setPadding(0,0,0,0)}
        }
        if (daily == 3) {
            btnContr.setBackgroundResource(R.drawable.cont_btn2)
            tvScore.setTextColor(getColor(R.color.blancnotan))
        }
    }
    fun initListeners(){
        btnContr.setOnClickListener{
            if (daily<3){
                val intent = Intent(this@ActivityGremi, ActivityMision::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }
        back.setOnClickListener{
            val intent = Intent(this, ActivityMain::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        btnRank.setOnClickListener{
            val intent = Intent(this, ActivityRank::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        btnProf.setOnClickListener{
            val intent = Intent(this, ActivityProfile::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }
}