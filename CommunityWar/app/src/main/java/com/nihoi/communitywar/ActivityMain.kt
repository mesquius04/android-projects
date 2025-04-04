package com.nihoi.communitywar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.math.E
import kotlin.math.exp
import kotlin.math.ln
import kotlin.math.sqrt

class ActivityMain : AppCompatActivity() {
    private lateinit var btnGremi: View
    private lateinit var tvNomG : TextView
    private lateinit var tvLvlM : TextView
    private lateinit var tvNomCast : TextView
    private lateinit var pbLvl : ProgressBar
    private lateinit var tvExpM : TextView
    private lateinit var btnRank : ImageView
    private lateinit var drac : ImageView
    private lateinit var currentPlayer:PlayersModel
    private lateinit var playerPref:PlayerPreferences
    private lateinit var btnProf : ImageView
    private lateinit var btnGoals : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initVars()
        initListeners()
    }
    private fun initVars(){
        playerPref=PlayerPreferences(this)
        currentPlayer=playerPref.getPlayerModel()!!
        btnGremi=findViewById(R.id.btngremi)
        btnRank=findViewById(R.id.ivrank)
        pbLvl=findViewById(R.id.progressBar)
        btnGoals=findViewById(R.id.ivGoals)
        btnProf=findViewById(R.id.ivProfile)
        tvNomCast=findViewById(R.id.textView)
        tvNomG=findViewById(R.id.textView2)
        tvExpM=findViewById(R.id.textView3)
        tvLvlM=findViewById(R.id.textView4)
        tvNomG.text=currentPlayer.playerName
        tvLvlM.text=currentPlayer.lvl.toString()
        tvExpM.text=currentPlayer.exp.toString()+"/"+(g(currentPlayer.lvl!!)).toString()
        pbLvl.max=g(currentPlayer.lvl!!)
        if (currentPlayer.castleName!=""){
            tvNomCast.setText(currentPlayer.castleName)
        }
        pbLvl.progress=currentPlayer.exp
    }
    private fun initListeners(){
        btnGremi.setOnClickListener{
            if (currentPlayer.castleName!=""){
                val intent = Intent(this, ActivityGremi::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }else{
            val intent = Intent(this, ActivityNoCastle::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
        }
        btnRank.setOnClickListener{
            val intent = Intent(this, ActivityRank::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        btnProf.setOnClickListener{
            val intent = Intent(this, ActivityProfile::class.java)
            startActivity(intent)
        }
    }
    fun g(x: Int): Int {
        return (x * x * exp(0.001 * x + 1) + 50 * x).toInt()
    }
}