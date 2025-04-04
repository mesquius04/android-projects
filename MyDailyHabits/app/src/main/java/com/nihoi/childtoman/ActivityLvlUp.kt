package com.nihoi.childtoman
import  android.content.Context
import android.content.Intent
import android.os.Bundle
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlin.collections.ArrayList

class ActivityLvlUp : AppCompatActivity(){
    lateinit var tvLvl : TextView
    lateinit var tvLvlPrev : TextView
    lateinit var fondo : ConstraintLayout
    lateinit var pref : SharedPreferences
    lateinit var editor : SharedPreferences.Editor
    var lvl:Int=0
    var prev:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvlup)
        initVars()
        initListeners()
    }
    fun initVars(){
        pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        editor=pref.edit()
        lvl=pref.getInt("lvl",2)
        prev=pref.getInt("prevlvl",1)
        tvLvl=findViewById(R.id.textView23)
        tvLvlPrev=findViewById(R.id.textView18)
        fondo=findViewById(R.id.fondoo)
        tvLvl.text=lvl.toString()
        tvLvlPrev.text=prev.toString()+" ->"
    }
    fun initListeners(){
        fondo.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}