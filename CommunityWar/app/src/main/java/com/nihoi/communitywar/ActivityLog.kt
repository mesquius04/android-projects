package com.nihoi.communitywar

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Date

class ActivityLog : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var ivlog:ImageView
    private lateinit var etUsername:EditText
    private lateinit var cbStayLogged:CheckBox
    private lateinit var etPassword:EditText
    private lateinit var da:SimpleDateFormat
    private lateinit var dat: Date
    private lateinit var data:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        initVars()
        initListeners()
    }
    fun initVars(){
        ivlog=findViewById(R.id.ivLog)
        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        cbStayLogged=findViewById(R.id.cbLo)
        auth=FirebaseAuth.getInstance()
        da = SimpleDateFormat("d/M/yyyy")
        dat = Date()
        data = da.format(dat)
    }
    fun initListeners(){
        ivlog.setOnClickListener{
            //correct(etUsername.text.toString(),etPassword.text.toString()) //Should be this, removed to test without API key

            // Remove this if valid API Key
            val playerPreferences = PlayerPreferences(this)

            // Si no hay un jugador guardado en las preferencias, creamos uno "default"
            if (playerPreferences.getPlayerModel() == null) {
                val defaultPlayer = PlayersModel(
                    playerName = "Guest",  // Nombre por defecto
                    password = "",         // Contraseña vacía
                    lvl = 3,               // Nivel inicial
                    exp = 8,               // Exp por defecto
                    castleName = "Heladia"        // Nombre de castillo vacío
                )
                playerPreferences.savePlayerModel(defaultPlayer)
            }

            // Lanzamos la siguiente actividad
            val intent = Intent(this, ActivityMain::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }
    fun correct(username: String, password: String){
        val dbRef = FirebaseDatabase.getInstance("https://community-wars-default-rtdb.europe-west1.firebasedatabase.app").getReference("Community Wars")
        val usersRef = dbRef.child("Players")
        val intent = Intent(this, ActivityMain::class.java)
        usersRef.orderByChild("playerName").equalTo(username).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (userSnapshot in dataSnapshot.children) {
                    val userId = userSnapshot.key
                    val player = userSnapshot.getValue(PlayersModel::class.java)
                    if (player != null && player.password.equals(password)) {
                        val playerPreferences=PlayerPreferences(this@ActivityLog)
                        playerPreferences.savePlayerModel(player)
                        startActivity(intent)
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        return
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error en la consulta de la base de datos
                return
            }
        }
        )
    }

}