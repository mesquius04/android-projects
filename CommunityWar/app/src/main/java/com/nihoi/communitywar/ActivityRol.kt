package com.nihoi.communitywar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ActivityRol : AppCompatActivity() {
    private lateinit var explorole:ConstraintLayout
    private lateinit var recolrole:ConstraintLayout
    private lateinit var atqrole:ConstraintLayout
    private lateinit var defrole:ConstraintLayout
    private lateinit var tvCast:TextView
    private lateinit var tvNec1:TextView
    private lateinit var tvNec2:TextView
    private lateinit var tvNec3:TextView
    private lateinit var tvNec4:TextView
    private lateinit var classinfo:ConstraintLayout
    private lateinit var classFoto:ImageView
    private lateinit var backbtn: ImageView
    private lateinit var elejirclass: ImageView
    private lateinit var currentPlayer:PlayersModel
    private lateinit var playerPref:PlayerPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rol)
        initVars()
        initListeners()
    }

    fun initVars(){
        playerPref=PlayerPreferences(this)
        currentPlayer=playerPref.getPlayerModel()!!
        tvCast=findViewById(R.id.textView45)
        tvCast.setText(currentPlayer.castleName)
        classinfo=findViewById(R.id.classinfo)
        explorole=findViewById(R.id.explorrole)
        recolrole=findViewById(R.id.recolrole)
        atqrole=findViewById(R.id.atqrole)
        defrole=findViewById(R.id.defrole)
        tvNec1=findViewById(R.id.tvNec1)
        tvNec2=findViewById(R.id.tvNec2)
        tvNec3=findViewById(R.id.tvNec3)
        tvNec4=findViewById(R.id.tvNec4)
        classFoto=findViewById(R.id.imageView33)
        backbtn=findViewById(R.id.imageView34)
        elejirclass=findViewById(R.id.imageView36)
    }

    fun initListeners(){
        explorole.setOnClickListener{
            classinfo.visibility= View.VISIBLE
            classFoto.setBackgroundResource(R.drawable.explor)
            currentPlayer.type=2
        }
        recolrole.setOnClickListener{
            classinfo.visibility= View.VISIBLE
            classFoto.setBackgroundResource(R.drawable.recol)
            currentPlayer.type=1
        }
        atqrole.setOnClickListener{
            classinfo.visibility= View.VISIBLE
            classFoto.setBackgroundResource(R.drawable.atq)
            currentPlayer.type=3
        }
        defrole.setOnClickListener{
            classinfo.visibility= View.VISIBLE
            classFoto.setBackgroundResource(R.drawable.def)
            currentPlayer.type=4
        }
        backbtn.setOnClickListener{
            classinfo.visibility=View.GONE
        }
        elejirclass.setOnClickListener{
            updateAll();
            val intent = Intent(this, ActivityMain::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
    fun updateAll(){
        val dbRef = FirebaseDatabase.getInstance("https://community-wars-default-rtdb.europe-west1.firebasedatabase.app").getReference("Community Wars")
        val usersRef = dbRef.child("Players")

        usersRef.orderByChild("playerName").equalTo(currentPlayer.playerName).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (userSnapshot in dataSnapshot.children) {
                    val player = userSnapshot.getValue(PlayersModel::class.java)
                    if (player != null && player.password.equals(currentPlayer.password)) {
                        userSnapshot.child("type").ref.setValue(currentPlayer.type)
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error en la consulta de la base de datos
                return
            }
        })

    }
}