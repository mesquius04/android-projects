package com.nihoi.childtoman
import  android.content.Context
import android.content.Intent
import android.os.Bundle
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.collections.ArrayList

class Goals : AppCompatActivity(){
    var total =0
    private lateinit var clase : String
    private lateinit var pref : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var backtohome : ImageView
    private var imageViewsList: ArrayList<ImageView>? = null
    private var textViewsList: ArrayList<TextView>? = null
    private var textViewsList2: ArrayList<TextView>? = null
    private lateinit var actualTitle: String
    private var lvl=0
    private lateinit var tvtituls : TextView
    /*val gymsc = pref.getInt("gymsc",0)
    val learnsc = pref.getInt("learnsc",0)
    val moneysc = pref.getInt("moneysc",0)
    val sleepsc = pref.getInt("sleepsc",0)
    val totalsc = pref.getInt("totalsc",0)
    private lateinit var tvgymsc : TextView
    private lateinit var tvlearnsc : TextView
    private lateinit var tvmoneysc : TextView
    private lateinit var tvsleepsc : TextView
    private lateinit var tvtotalsc : TextView*/
    private lateinit var tvclase : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals)

        imageViewsList = ArrayList()
        textViewsList = ArrayList()
        textViewsList2 = ArrayList()

        pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        editor=pref.edit()
        initVar()
        initListeners()
        lvl=pref.getInt("lvl",1)

        val currentProgress = (lvl/5+1)

        for (i in 0 until 15) {
            val imageView = imageViewsList!![i]
            val textView = textViewsList!![i]
            val textView2 = textViewsList2!![i]

            if (i < currentProgress) {
                imageView.setColorFilter(ContextCompat.getColor(this, R.color.golden))
                textView.setTextColor(ContextCompat.getColor(this, R.color.cardview_dark_background))
                textView2.setTextColor(ContextCompat.getColor(this, R.color.cardview_dark_background))
                actualTitle=textView.text.toString()
            } else {
                imageView.setColorFilter(ContextCompat.getColor(this, R.color.black))
                textView.setTextColor(ContextCompat.getColor(this, R.color.blacknotan))
                textView2.setTextColor(ContextCompat.getColor(this, R.color.blacknotan))
            }
            var user=pref.getString("username","user")!!
            tvclase.text= user + ", el "+ actualTitle
            editor.putString("title",actualTitle)
        }

    }

    fun initVar(){
        backtohome=findViewById(R.id.ivBacktoMain)
        clase=pref.getString("CLASS","none")!!
        tvclase=findViewById(R.id.tvClase)
        tvtituls=findViewById(R.id.tvTitulos)
        tvtituls.text= "CLASE "+clase+" - TÍTULOS HONORIFICOS"



        textViewsList?.add(0,findViewById(R.id.tvT1))
        textViewsList?.add(1,findViewById(R.id.tvT2))
        textViewsList?.add(2,findViewById(R.id.tvT3))
        textViewsList?.add(3,findViewById(R.id.tvT4))
        textViewsList?.add(4,findViewById(R.id.tvT5))
        textViewsList?.add(5,findViewById(R.id.tvT6))
        textViewsList?.add(6,findViewById(R.id.tvT7))
        textViewsList?.add(7,findViewById(R.id.tvT8))
        textViewsList?.add(8,findViewById(R.id.tvT9))
        textViewsList?.add(9,findViewById(R.id.tvT10))
        textViewsList?.add(10,findViewById(R.id.tvT11))
        textViewsList?.add(11,findViewById(R.id.tvT12))
        textViewsList?.add(12,findViewById(R.id.tvT13))
        textViewsList?.add(13,findViewById(R.id.tvT14))
        textViewsList?.add(14,findViewById(R.id.tvT15))

        textViewsList2?.add(0,findViewById(R.id.tvT1e))
        textViewsList2?.add(1,findViewById(R.id.tvT2e))
        textViewsList2?.add(2,findViewById(R.id.tvT3e))
        textViewsList2?.add(3,findViewById(R.id.tvT4e))
        textViewsList2?.add(4,findViewById(R.id.tvT5e))
        textViewsList2?.add(5,findViewById(R.id.tvT6e))
        textViewsList2?.add(6,findViewById(R.id.tvT7e))
        textViewsList2?.add(7,findViewById(R.id.tvT8e))
        textViewsList2?.add(8,findViewById(R.id.tvT9e))
        textViewsList2?.add(9,findViewById(R.id.tvT10e))
        textViewsList2?.add(10,findViewById(R.id.tvT11e))
        textViewsList2?.add(11,findViewById(R.id.tvT12e))
        textViewsList2?.add(12,findViewById(R.id.tvT13e))
        textViewsList2?.add(13,findViewById(R.id.tvT14e))
        textViewsList2?.add(14,findViewById(R.id.tvT15e))

        imageViewsList?.add(0,findViewById(R.id.ivT1))
        imageViewsList?.add(1,findViewById(R.id.ivT2))
        imageViewsList?.add(2,findViewById(R.id.ivT3))
        imageViewsList?.add(3,findViewById(R.id.ivT4))
        imageViewsList?.add(4,findViewById(R.id.ivT5))
        imageViewsList?.add(5,findViewById(R.id.ivT6))
        imageViewsList?.add(6,findViewById(R.id.ivT7))
        imageViewsList?.add(7,findViewById(R.id.ivT8))
        imageViewsList?.add(8,findViewById(R.id.ivT9))
        imageViewsList?.add(9,findViewById(R.id.ivT10))
        imageViewsList?.add(10,findViewById(R.id.ivT11))
        imageViewsList?.add(11,findViewById(R.id.ivT12))
        imageViewsList?.add(12,findViewById(R.id.ivT13))
        imageViewsList?.add(13,findViewById(R.id.ivT14))
        imageViewsList?.add(14,findViewById(R.id.ivT15))
    }
    fun initListeners(){
        backtohome.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}