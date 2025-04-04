package com.nihoi.communitywar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.math.exp
import kotlin.random.Random

class ActivityRecompensa : AppCompatActivity() {
    private lateinit var btnCol:ConstraintLayout
    private lateinit var tvExp:TextView
    private lateinit var tvFood:TextView
    private lateinit var tvMeters:TextView
    private lateinit var tvExplor:TextView
    private lateinit var tvDef:TextView
    private lateinit var tvAtq:TextView
    private lateinit var tvTotMiss:TextView
    private lateinit var tvCol:TextView
    private lateinit var currentPlayer:PlayersModel
    private lateinit var playerPref:PlayerPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recompensa)
        initVars()
        initListeners()
        computeResult()
        updateStats()
        initTrans()
        animateButt()
    }
    fun initVars(){
        playerPref=PlayerPreferences(this)
        currentPlayer=playerPref.getPlayerModel()!!
        btnCol=findViewById(R.id.ivCOl)
        tvExp=findViewById(R.id.tvexp)
        tvMeters=findViewById(R.id.textView21)
        tvFood=findViewById(R.id.tvfood)
        tvExplor=findViewById(R.id.tvexplor)
        tvDef=findViewById(R.id.tvdef)
        tvAtq=findViewById(R.id.tvatq)
        tvTotMiss=findViewById(R.id.tvTot)
        tvCol=findViewById(R.id.tvColab)
    }
    fun initListeners(){
        btnCol.setOnClickListener{
            val intent = Intent(this@ActivityRecompensa, ActivityGremi::class.java)
            startActivity(intent)
            // Finalizar la Activity actual si no quieres que el usuario pueda regresar
            finish()
        }

    }
    fun initTrans() {
        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
        val fadeinanim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        slideInAnimation.duration = 500
        fadeinanim.duration=500

        val textViews = listOf(tvExp, tvFood, tvExplor, tvDef, tvAtq, tvTotMiss, tvCol)

        for ((index, textView) in textViews.withIndex()) {
            var animationWithDelay = getAnimationWithDelay(slideInAnimation, index * 500)
            if (index in 2..4){animationWithDelay = getAnimationWithDelay(slideInAnimation, index * 200)}
            else if (index == 5){animationWithDelay = getAnimationWithDelay(fadeinanim, index * 400)}
            else if (index == 6){animationWithDelay = getAnimationWithDelay(slideInAnimation, index * 200)}
            textView.startAnimation(animationWithDelay)
            textView.visibility = View.VISIBLE
        }
    }
    fun computeResult() : Int{
        var tot=Random.nextInt((currentPlayer.lvl!!/10).toInt()+13, 30)+20
        var totalmeter=(Random.nextInt(50,currentPlayer.lvl!!+65)+15+currentPlayer.lvl!!*3).toInt()
        var expgetted=Random.nextInt(totalmeter,totalmeter*5/3)
        var explor=0
        var def=0
        var atq=0
        var recol=0
        when (currentPlayer.type){
            1->{recol=(tot/2)-Random.nextInt(1,2)
                explor=(tot/3)-Random.nextInt(1,3)
                def=(tot/5)+Random.nextInt(1,2)
                atq=tot-recol-explor-def
            }
            2->{explor=(tot/2)-Random.nextInt(1,2)
                recol=(tot/3)-Random.nextInt(1,3)
                def=(tot/5)+Random.nextInt(1,2)
                atq=tot-recol-explor-def
            }
            3->{atq=(tot/2)-Random.nextInt(1,2)
                def=(tot/3)-Random.nextInt(1,3)
                recol=(tot/5)+Random.nextInt(1,2)
                explor=tot-recol-explor-def
            }
            4->{def=(tot/2)-Random.nextInt(1,2)
                atq=(tot/3)-Random.nextInt(1,3)
                explor=(tot/5)+Random.nextInt(1,2)
                recol=tot-recol-explor-def
            }
        }
        tvFood.text="+"+recol.toString()
        tvAtq.text="+"+atq.toString()
        tvDef.text="+"+def.toString()
        tvExplor.text="+"+explor.toString()
        tvExp.text="+"+expgetted.toString()
        tvTotMiss.text="+"+tot.toString()
        tvMeters.text=totalmeter.toString()+"m recorridos!"

        currentPlayer.exp+=expgetted
        while (currentPlayer.exp>=g(currentPlayer.lvl)){
            currentPlayer.exp-=g(currentPlayer.lvl)
            currentPlayer.lvl += 1
        }
        currentPlayer.totalsc+=tot
        currentPlayer.daily+=1

        return tot
    }

    private fun getAnimationWithDelay(animation: Animation, delay: Int): Animation {
        val anim = AnimationUtils.loadAnimation(this, R.anim.slide_in_right) // Cambia AlphaAnimation por la animación que necesitas
        anim.duration = animation.duration
        anim.startOffset = delay.toLong()
        return anim
    }
    fun animateButt(){
        val scaleAnimation = ScaleAnimation(
            1.0f, 1.05f, // Escala de inicio y fin en el eje X
            1.0f, 1.05f, // Escala de inicio y fin en el eje Y
            Animation.RELATIVE_TO_SELF, 0.5f, // Punto de pivote X (centro)
            Animation.RELATIVE_TO_SELF, 0.5f  // Punto de pivote Y (centro)
        )

        scaleAnimation.duration = 1000 // Duración de la animación en milisegundos
        scaleAnimation.repeatCount = Animation.INFINITE // Repetir infinitamente
        scaleAnimation.repeatMode = Animation.REVERSE // Invertir la animación al repetir

        // Aplicar un interpolador lineal para un efecto más suave
        val interpolator = LinearInterpolator()
        scaleAnimation.interpolator = interpolator

        btnCol.startAnimation(scaleAnimation)
    }
    fun updateStats(){
        val dbRef = FirebaseDatabase.getInstance("https://community-wars-default-rtdb.europe-west1.firebasedatabase.app").getReference("Community Wars")
        val usersRef = dbRef.child("Players")

        usersRef.orderByChild("playerName").equalTo(currentPlayer.playerName).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (userSnapshot in dataSnapshot.children) {
                    val player = userSnapshot.getValue(PlayersModel::class.java)
                    if (player != null && player.password.equals(currentPlayer.password)) {
                        userSnapshot.child("totalsc").ref.setValue(currentPlayer.totalsc)
                        userSnapshot.child("daily").ref.setValue(currentPlayer.daily)
                        userSnapshot.child("exp").ref.setValue(currentPlayer.exp)
                        userSnapshot.child("lvl").ref.setValue(currentPlayer.lvl)
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error en la consulta de la base de datos
                return
            }
        })
    }
    fun g(x: Int): Int {
        return (x * x * exp(0.001 * x + 1) + 50 * x).toInt()
    }
}