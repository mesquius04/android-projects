package com.nihoi.communitywar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ActivityNoCastle : AppCompatActivity() {
    private lateinit var etCastle : EditText
    private lateinit var chose1 : ConstraintLayout
    private lateinit var chose2 : ConstraintLayout
    private lateinit var chose3 : ConstraintLayout
    private lateinit var chose4 : ConstraintLayout
    private lateinit var joinbtn : ImageView
    private lateinit var createC : View
    private lateinit var currentPlayer:PlayersModel
    private lateinit var playerPref:PlayerPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_castle)
        initVars()
        initListeners()
    }

    fun initVars(){
        playerPref=PlayerPreferences(this)
        currentPlayer=playerPref.getPlayerModel()!!
        etCastle=findViewById(R.id.editText)
        chose1=findViewById(R.id.choice1)
        chose2=findViewById(R.id.choice2)
        chose3=findViewById(R.id.choice3)
        chose4=findViewById(R.id.choice4)
        joinbtn=findViewById(R.id.imageView21)
        createC=findViewById(R.id.view5)
    }
    fun initListeners(){
        chose1.setOnClickListener{
            update(getString(R.string.castle1))
            val intent = Intent(this, ActivityRol::class.java)
            startActivity(intent)
        }
        chose2.setOnClickListener {
            update(getString(R.string.castle2))
            val intent = Intent(this, ActivityRol::class.java)
            startActivity(intent)
        }
        chose3.setOnClickListener {
            update(getString(R.string.castle3))
            val intent = Intent(this, ActivityRol::class.java)
            startActivity(intent)
        }
        chose4.setOnClickListener {
            update(getString(R.string.castle4))
            val intent = Intent(this, ActivityRol::class.java)
            startActivity(intent)
        }
        joinbtn.setOnClickListener{
        }
        createC.setOnClickListener {

        }
    }
    fun update(nom : String){
        val dbRef = FirebaseDatabase.getInstance("https://community-wars-default-rtdb.europe-west1.firebasedatabase.app").getReference("Community Wars")
        val usersRef = dbRef.child("Players")

        usersRef.orderByChild("playerName").equalTo(currentPlayer.playerName).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (userSnapshot in dataSnapshot.children) {
                    val player = userSnapshot.getValue(PlayersModel::class.java)
                    if (player != null && player.password.equals(currentPlayer.password)) {
                        userSnapshot.child("castleName").ref.setValue(nom)
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