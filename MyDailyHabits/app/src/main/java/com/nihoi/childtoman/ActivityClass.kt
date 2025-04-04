package com.nihoi.childtoman
import  android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ActivityClass : AppCompatActivity(){
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var ivA: ImageView
    lateinit var ivM: ImageView
    lateinit var ivC: ImageView
    lateinit var ivG: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class)
        initVar()
        initListeners()

    }
    fun initVar(){
        ivA=findViewById(R.id.ivA)
        ivG=findViewById(R.id.ivG)
        ivM=findViewById(R.id.ivM)
        ivC=findViewById(R.id.ivC)
        pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        editor = pref.edit()
    }
    fun initListeners(){
        val intent = Intent(this, MainActivity::class.java)
        ivA.setOnClickListener {
            editor.putString("CLASS","A")
            editor.apply()
            startActivity(intent)
        }
        ivG.setOnClickListener {
            editor.putString("CLASS","G")
            editor.apply()
            startActivity(intent)
        }
        ivM.setOnClickListener {
            editor.putString("CLASS","M")
            editor.apply()
            startActivity(intent)
        }
        ivC.setOnClickListener {
            editor.putString("CLASS","C")
            editor.apply()
            startActivity(intent)
        }
    }
}