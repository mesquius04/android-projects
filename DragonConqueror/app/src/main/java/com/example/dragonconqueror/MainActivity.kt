package com.example.dragonconqueror
import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.random.Random
import android.content.res.Resources
import androidx.core.view.marginLeft

var time=5
var perfil=4000
var totaltime=time
var actualscore=10000000
var actualscore2=actualscore
var clickscore=1
var first=0
var second=0
var third=0
var four=0
var actual=0
var dragon1200= 0
var dragon5000=0
var dragon25000=0
var dragon200000=0
var dragon10000000=0

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
class MainActivity : AppCompatActivity() {
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fondo=findViewById<ImageView>(R.id.imageView)
        val fondo2=findViewById<ImageView>(R.id.imageView2)
        val fondo3=findViewById<ImageView>(R.id.imageView3)
        val imageButton0=findViewById<ImageButton>(R.id.imatgeinicial)
        val imageButton1=findViewById<ImageButton>(R.id.imagebutton)
        val imageButton2=findViewById<ImageButton>(R.id.imagebutton2)
        val imageButton2c=findViewById<ImageButton>(R.id.imagebutton2c)
        val imageButton3=findViewById<ImageButton>(R.id.imagebutton3)
        val imageButton4=findViewById<ImageButton>(R.id.imagebutton4)
        val imageButton5=findViewById<ImageButton>(R.id.imagebutton5)
        val imageBuff=findViewById<ImageButton>(R.id.imagebuttonbuff)
        val imageBuff2=findViewById<ImageButton>(R.id.imagebuttonbuff2)
        val imageBuff3=findViewById<ImageButton>(R.id.imagebuttonbuff3)
        val imageBuff4=findViewById<ImageButton>(R.id.imagebuttonbuff4)
        val imageBuff5=findViewById<ImageButton>(R.id.imagebuttonbuff5)
        val imageButtonShop=findViewById<ImageButton>(R.id.imagebuttonshop)
        val imageView0=findViewById<TextView>(R.id.textinicial)
        val linear=findViewById<LinearLayout>(R.id.linear)
        val imageView1=findViewById<ImageView>(R.id.imageView3)
        val tvVariable = findViewById<TextView>(R.id.tvVariable)
        val tvVariable2 = findViewById<TextView>(R.id.tvVariable3)
        var pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        var editor = pref.edit()
        var openhour=System.currentTimeMillis().toInt()
        var closehour=pref.getInt("closehour", openhour)
        totaltime=pref.getInt("totaltime",time)
        actualscore=pref.getInt("actualscore",1)
        actualscore2=pref.getInt("actualscore2",1)
        clickscore=pref.getInt("clickerscore",1)
        first=pref.getInt("first",0)
        second=pref.getInt("second",0)
        third=pref.getInt("third",0)
        four=pref.getInt("four",0)
        actual=pref.getInt("actual",0)
        dragon1200= pref.getInt("dragon1200",0)
        dragon5000= pref.getInt("dragon5000",0)
        dragon25000= pref.getInt("dragon25000", 0)
        dragon200000= pref.getInt("dragon200000", 0)
        dragon10000000= pref.getInt("dragon10000000",0)
        totaltime= pref.getInt("totaltime",5)

        var diferencia=openhour-closehour
        if (diferencia!=0){
            if ((totaltime*diferencia)>0){
            actualscore+= ((totaltime*diferencia)/(1000*60))}
            else{
                actualscore+= (-(totaltime*diferencia)/(1000*60))
            }
        }

        imageButton0.setOnClickListener{
            when (actual) {
                0 -> {
                    imageButton0.visibility=View.GONE
                    imageView0.visibility=View.GONE
                    imageButton1.visibility=View.VISIBLE
                    imageButtonShop.visibility=View.VISIBLE
                    linear.visibility=View.VISIBLE
                    fondo.visibility=View.VISIBLE
                    fondo2.visibility=View.VISIBLE
                    fondo3.visibility=View.VISIBLE
                    editor.putInt("totaltime", totaltime)
                    editor.commit()
                }
                1 -> {imageButton0.visibility=View.GONE
                    imageView0.visibility=View.GONE
                    imageButton1.visibility=View.GONE
                    imageView1.visibility=View.GONE
                    imageButtonShop.visibility=View.VISIBLE
                    linear.visibility=View.VISIBLE
                    fondo.visibility=View.VISIBLE
                    fondo2.visibility=View.VISIBLE
                    fondo3.visibility=View.GONE
                    imageButton2.visibility=View.VISIBLE
                    clickscore=2
                    editor.putInt("clickerscore", clickscore)
                    editor.putInt("actualscore", actualscore)
                    editor.putInt("totaltime", totaltime)
                    editor.commit()}
                2 -> {
                    imageButton0.visibility=View.GONE
                    imageView0.visibility=View.GONE
                    imageButton1.visibility=View.GONE
                    imageView1.visibility=View.GONE
                    imageButton2.visibility=View.GONE
                    imageButton2c.visibility=View.GONE
                    fondo3.visibility=View.GONE
                    imageButtonShop.visibility=View.VISIBLE
                    linear.visibility=View.VISIBLE
                    fondo.visibility=View.VISIBLE
                    fondo2.visibility=View.VISIBLE
                    imageButton3.visibility=View.VISIBLE
                    clickscore=5
                    editor.putInt("totaltime", totaltime)
                    editor.putInt("actualscore", actualscore)
                    editor.putInt("clickerscore", clickscore)
                    editor.commit()
                }
                3 -> {
                    imageButton0.visibility=View.GONE
                    imageView0.visibility=View.GONE
                    imageButton1.visibility=View.GONE
                    imageView1.visibility=View.GONE
                    imageButton3.visibility=View.GONE
                    fondo3.visibility=View.GONE
                    imageButtonShop.visibility=View.VISIBLE
                    linear.visibility=View.VISIBLE
                    fondo.visibility=View.VISIBLE
                    fondo2.visibility=View.VISIBLE
                    imageButton4.visibility=View.VISIBLE
                    clickscore=30
                    editor.putInt("actualscore", actualscore)
                    editor.putInt("totaltime", totaltime)
                    editor.putInt("clickerscore", clickscore)
                    editor.commit()}
                4 -> {
                    imageButton0.visibility=View.GONE
                    imageView0.visibility=View.GONE
                    imageButton1.visibility=View.GONE
                    imageView1.visibility=View.GONE
                    imageButton4.visibility=View.GONE
                    fondo3.visibility=View.GONE
                    imageButtonShop.visibility=View.VISIBLE
                    linear.visibility=View.VISIBLE
                    fondo.visibility=View.VISIBLE
                    fondo2.visibility=View.VISIBLE
                    imageButton5.visibility=View.VISIBLE
                    clickscore=100
                    editor.putInt("actualscore", actualscore)
                    editor.putInt("totaltime", totaltime)
                    editor.putInt("clickerscore", clickscore)
                    editor.commit()
                }
            }

        }
        imageButton1.setOnClickListener {
            actualscore+= clickscore
            actualscore2+= clickscore
            editor.putInt("actualscore", actualscore)
            editor.commit()
            tvVariable.text = actualscore.toString()
            if (actualscore>=100){
                actual=1
                imageButton1.visibility=View.GONE
                imageView1.visibility=View.GONE
                actualscore-=100
                imageButton2.visibility=View.VISIBLE
                clickscore=2
                editor.putInt("actual",actual)
                editor.commit()
                editor.putInt("actualscore", actualscore)
                editor.commit()
            }
        }
        imageButton2.setOnClickListener {
            actualscore+= clickscore
            actualscore2+= clickscore
            editor.putInt("actualscore", actualscore)
            editor.commit()
            tvVariable.text = actualscore.toString()
            if (actualscore>=20000){
                imageButton2.visibility=View.GONE
                imageButton2c.visibility=View.GONE
                imageButton3.visibility=View.VISIBLE
                clickscore=5
                actual=2
                editor.putInt("actual",2)
                editor.commit()
                actualscore-=20000
                editor.putInt("actualscore", actualscore)
                editor.commit()
            }
            if (actualscore2>perfil && actualscore<=20000){
                perfil+=4000
                imageButton2.visibility=View.GONE
                imageButton2c.visibility=View.VISIBLE
            }
        }
        imageButton2c.setOnClickListener{
            actualscore+= clickscore
            actualscore2+= clickscore
            editor.putInt("actualscore", actualscore)
            editor.commit()
            tvVariable.text = actualscore.toString()
            if (actualscore>=20000){
                actualscore-=20000
                imageButton2c.visibility=View.GONE
                imageButton3.visibility=View.VISIBLE
                clickscore=10
                actual=2
                editor.putInt("clickscore",10)
                editor.putInt("actualscore", actualscore)
                editor.putInt("actual",2)
                editor.commit()
            }
            if (actualscore2>perfil && actualscore<=20000){
                perfil+=4000
                imageButton2c.visibility=View.GONE
                imageButton2.visibility=View.VISIBLE
            }
        }
        imageButton3.setOnClickListener{
            actualscore+= clickscore
            actualscore2+= clickscore
            editor.putInt("actualscore", actualscore)
            editor.commit()
            tvVariable.text = actualscore.toString()
            if (actualscore>=200000){
                actualscore-=200000
                imageButton3.visibility=View.GONE
                imageButton4.visibility=View.VISIBLE
                clickscore=30
                actual=3
                editor.putInt("actualscore", actualscore)
                editor.putInt("actual",3)
                editor.commit()
            }
        }
        imageButton4.setOnClickListener{
            actualscore+= clickscore
            actualscore2+= clickscore
            editor.putInt("actualscore", actualscore)
            editor.commit()
            tvVariable.text = actualscore.toString()
            if (actualscore>=2500000){
                actualscore-=2500000
                imageButton4.visibility=View.GONE
                imageButton5.visibility=View.VISIBLE
                clickscore=100
                actual=4
                editor.putInt("actualscore", actualscore)
                editor.putInt("actual",4)
                editor.commit()
            }
        }
        imageButton5.setOnClickListener{
            actualscore+= clickscore
            editor.putInt("actualscore", actualscore)
            actualscore2+= clickscore
            editor.commit()
            tvVariable.text = actualscore.toString()
        }
        val runnable = object : Runnable {
            override fun run() {
                actualscore += 1
                actualscore2+= 1
                tvVariable.text = actualscore.toString()
                editor.putInt("actualscore", actualscore)
                editor.putInt("actualscore2", actualscore2)
                editor.putInt("totaltime", totaltime)
                editor.putInt("closehour", System.currentTimeMillis().toInt())
                editor.commit()
                println(actualscore)
                handler.postDelayed(this, (60000/ totaltime).toLong())
                tvVariable.text = actualscore.toString()
                var stotaltime= String.format("%d",totaltime)
                tvVariable2.text= stotaltime
                if (dragon1200!=0){
                    imageButton1.visibility=View.GONE
                    imageView1.visibility=View.GONE
                    editor.putInt("totaltime", totaltime)
                    editor.putInt("dragon1200", dragon1200)
                    editor.commit()
                    imageBuff.visibility=View.VISIBLE
                    if (dragon1200 in 10..25){
                        imageBuff.setBackgroundResource(R.drawable.boss_continental_turtle_rukkha)
                        val params = imageBuff.layoutParams
                        params.width=75.dp
                        params.height=75.dp
                        first=1
                        editor.putInt("first",1)
                        editor.commit()
                        imageBuff.layoutParams = params
                    }
                }
                if (dragon5000!=0){
                    editor.putInt("dragon5000", dragon5000)
                    editor.putInt("totaltime", totaltime)
                    editor.commit()
                    imageBuff2.visibility=View.VISIBLE
                    if (dragon5000 in 10..25){
                        imageBuff2.setBackgroundResource(R.drawable.boss_feral_kitsune)
                        val params2 = imageBuff2.layoutParams
                        params2.width=70.dp
                        params2.height=70.dp
                        second=1
                        editor.putInt("second",1)
                        editor.commit()
                        imageBuff2.layoutParams = params2
                    }
                }
                if (dragon25000!=0){
                    imageBuff3.visibility=View.VISIBLE
                    editor.putInt("dragon25000", dragon25000)
                    editor.putInt("totaltime", totaltime)
                    editor.commit()
                    if (dragon25000 in 10..25){
                        imageBuff3.setBackgroundResource(R.drawable.boss_sea_calamity_urmica)
                        val params3 = imageBuff3.layoutParams
                        params3.width=70.dp
                        params3.height=70.dp
                        third=1
                        editor.putInt("third",1)
                        editor.commit()
                        imageBuff3.layoutParams = params3
                    }
                }
                if (dragon200000!=0){
                    imageBuff4.visibility=View.VISIBLE
                    editor.putInt("dragon200000", dragon200000)
                    editor.putInt("totaltime", totaltime)
                    editor.commit()
                    if (dragon200000 in 10..25){
                        imageBuff4.setBackgroundResource(R.drawable.boss_khronos)
                        val params4 = imageBuff4.layoutParams
                        params4.width=70.dp
                        params4.height=70.dp
                        four=1
                        editor.putInt("four",1)
                        editor.commit()
                        imageBuff4.layoutParams = params4
                    }
                }
                if (dragon10000000!=0){
                    editor.putInt("dragon10000000", dragon10000000)
                    editor.putInt("totaltime", totaltime)
                    editor.commit()
                    imageBuff5.visibility=View.VISIBLE
                }
            }
        }
        handler.postDelayed(runnable, (60000/totaltime).toLong())

        imageButtonShop.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, Shop::class.java)
                startActivity(intent)
            }
        })
        imageBuff.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, Tier1::class.java)
                startActivity(intent)
            }
        })
        imageBuff2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, Tier2::class.java)
                startActivity(intent)
            }
        })
        imageBuff3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, Tier3::class.java)
                startActivity(intent)
            }
        })
        imageBuff4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, Tier4::class.java)
                startActivity(intent)
            }
        })
    }
}

