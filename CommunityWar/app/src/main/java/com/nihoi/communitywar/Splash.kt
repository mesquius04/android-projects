package com.nihoi.communitywar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.FirebaseApp

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        FirebaseApp.initializeApp(this)
        val duracio= 1500
        Handler().postDelayed({
            val intent = Intent(this@Splash, ActivityFirst::class.java)
            startActivity(intent)
            finish()
        }, duracio.toLong())
    }
}