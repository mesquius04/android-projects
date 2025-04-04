package com.nihoi.communitywar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityMision : AppCompatActivity() {
    private lateinit var pbMision:ProgressBar
    private var progressStatus = 0
    private lateinit var tvMision:TextView
    private val handler: Handler =  Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mision)
        initVars()
        val handler = Handler()

        Thread {
            while (progressStatus < 100) {
                progressStatus += 1

                // Actualizar la interfaz de usuario a través del hilo principal
                handler.post {
                    pbMision.setProgress(progressStatus)
                    tvMision.text = "$progressStatus%"

                    // Verificar si el progreso alcanzó el 100%
                    if (progressStatus == 100) {
                        // Si el progreso es 100, iniciar la nueva Activity
                        val intent = Intent(this@ActivityMision, ActivityRecompensa::class.java)
                        startActivity(intent)
                        // Finalizar la Activity actual si no quieres que el usuario pueda regresar
                        finish()
                    }
                }

                try {
                    // Dormir el hilo durante 100 milisegundos para simular trabajo
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()

    }
    fun initVars(){
        tvMision=findViewById(R.id.textView19)
        pbMision=findViewById(R.id.progressBar4)
    }

}