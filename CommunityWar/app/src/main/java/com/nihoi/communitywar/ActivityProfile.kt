package com.nihoi.communitywar

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.exp

class ActivityProfile : AppCompatActivity() {
    private lateinit var back:ImageView
    private lateinit var changeuser:ImageView
    private lateinit var tvRole : TextView
    private lateinit var tvNick : TextView
    private lateinit var tvLvlM : TextView
    private lateinit var pbLvl : ProgressBar
    private lateinit var currentPlayer:PlayersModel
    private lateinit var playerPref:PlayerPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initVars()
        initListeners()
    }
    fun initVars(){
        playerPref=PlayerPreferences(this)
        currentPlayer=playerPref.getPlayerModel()!!
        back=findViewById(R.id.backP)
        changeuser=findViewById(R.id.imageView27)
        tvRole=findViewById(R.id.textView17)
        tvNick=findViewById(R.id.textView6)
        tvLvlM=findViewById(R.id.textView4)
        pbLvl=findViewById(R.id.progressBar3)
        tvLvlM.text=currentPlayer.lvl.toString()
        tvNick.text=currentPlayer.playerName
        if (currentPlayer.type==1){
            tvRole.setText("LA HORMIGA RECOLECTORA")
        }else if(currentPlayer.type==2){
            tvRole.setText("LA HORMIGA EXPLORADORA")
        }else{tvRole.setText("LA HORMIGA SOLDADO")}
    }
    fun initListeners(){
        back.setOnClickListener{
            val intent = Intent(this, ActivityGremi::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }
        changeuser.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Cambiar nombre de usuario")

            val input = EditText(this)
            input.hint = "hormigita cachonda"
            input.textAlignment = View.TEXT_ALIGNMENT_CENTER
            val colorBlanco = ContextCompat.getColor(this, R.color.blancnotan)
            input.setTextColor(colorBlanco)
            input.setPadding(8,4,8,4)
            builder.setView(input)

            builder.setPositiveButton("Aceptar") { dialog, _ ->
                val newUsername = input.text.toString().trim()
                dialog.dismiss()
                val prevName=currentPlayer.playerName
                currentPlayer.playerName=newUsername


                val databaseReference = FirebaseDatabase.getInstance().getReference("Players").child(prevName)
                databaseReference.child("playerName").setValue(currentPlayer.playerName)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Nuevo nombre generado correctamente", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Error en acceso a la base de datos", Toast.LENGTH_LONG).show()
                        }
                    }


            }
            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }
            val dialog = builder.create()
            dialog.show()
        }
    }
    fun g(x: Int): Int {
        return (x*x * exp(0.001 * x + 1) + 50 * x).toInt()
    }
}