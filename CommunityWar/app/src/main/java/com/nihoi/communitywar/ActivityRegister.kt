package com.nihoi.communitywar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date

class ActivityRegister : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var ivlog: ImageView
    private lateinit var etUsername: EditText
    private lateinit var cbStayLogged: CheckBox
    private lateinit var etPassword: EditText
    private lateinit var etEmail: EditText
    private lateinit var da: SimpleDateFormat
    private lateinit var dat: Date
    private lateinit var dbRef:DatabaseReference
    private lateinit var etPassword2:EditText
    private lateinit var data:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initVars()
        initListeners()
    }
    fun initVars(){

        FirebaseApp.initializeApp(this)
        auth=FirebaseAuth.getInstance()
        ivlog=findViewById(R.id.ivLogR)
        etUsername=findViewById(R.id.etUsernameR)
        etPassword=findViewById(R.id.etPasswordR)
        etPassword2=findViewById(R.id.etPassword2R)
        cbStayLogged=findViewById(R.id.cbLoR)
        etEmail=findViewById(R.id.etEmailR)
        da = SimpleDateFormat("d/M/yyyy")
        dat = Date()
        dbRef = FirebaseDatabase.getInstance("https://community-wars-default-rtdb.europe-west1.firebasedatabase.app").getReference("Community Wars")
        data = da.format(dat)
    }
    fun initListeners(){
        ivlog.setOnClickListener{
            Log.i("FUNC","ENTER")
            validRegister(etUsername.text.toString(),etPassword.text.toString(),etPassword2.text.toString(),etEmail.text.toString())
        }
    }

    fun validRegister(name: String, pass1: String, pass2: String, email: String) {
        if (pass1 != pass2) {
            Log.i("NOTA1", "CONTRA ERROR")
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        auth.fetchSignInMethodsForEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val signInMethods = task.result?.signInMethods ?: emptyList<String>()

                    if (signInMethods.isEmpty()) {

                        auth.createUserWithEmailAndPassword(email, pass1)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser = auth.currentUser
                                    firebaseUser?.let { user ->
                                        val userId = dbRef.push().key!!
                                        val players = PlayersModel(userId, name, 1, pass1, email, 0, 0, 0,0,"")
                                        val playerPreferences=PlayerPreferences(this)
                                        playerPreferences.savePlayerModel(players)
                                        dbRef.child("Players").child(name).setValue(players)
                                            .addOnCompleteListener { task ->
                                                if (task.isSuccessful) {
                                                    Toast.makeText(this, "Usuario registrado y datos generados correctamente", Toast.LENGTH_LONG).show()
                                                    val intent = Intent(this, ActivityMain::class.java)
                                                    startActivity(intent)
                                                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                                                    finishAffinity()
                                                } else {
                                                    Toast.makeText(this, "Error al guardar datos en la base de datos: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                                                }
                                            }
                                            .addOnFailureListener { err ->
                                                Toast.makeText(this, "ERROR al guardar datos: ${err.message}", Toast.LENGTH_LONG).show()
                                            }
                                    }
                                } else {
                                    Toast.makeText(this, "Error en el registro: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        // El correo electrónico ya está en uso
                        Toast.makeText(this, "El correo electrónico ya está registrado", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Error al verificar el correo electrónico: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }



}