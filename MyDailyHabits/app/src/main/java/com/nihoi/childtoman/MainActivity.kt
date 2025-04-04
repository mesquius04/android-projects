package com.nihoi.childtoman
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Integer.max
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var perfil : LinearLayout
    lateinit var task : LinearLayout
    lateinit var goal : LinearLayout
    lateinit var grow : LinearLayout
    lateinit var ivFire : ImageView
    lateinit var tvUser : TextView
    lateinit var tvDaily : TextView
    lateinit var tvTotal : TextView
    lateinit var tvLvl : TextView
    lateinit var ivPerfil : ImageView
    lateinit var clase : String
    lateinit var vGym : View
    lateinit var vLearn : View
    lateinit var vMoney : View
    lateinit var vSleep : View
    lateinit var btnblau : FloatingActionButton
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var username: String
    var dailyScore: Int=0
    var totalScore: Int=0
    var lvl : Int =1
    var racha: Int=1
    var exp: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        check_all()
        initComponents()
        initListeners()
        configurarAlarmaReinicioDiario();
        ivFire.setPadding(max((46-(dailyScore/2)),4), max((46-(dailyScore/2)),4), max((46-(dailyScore/2)),4), max((46-(dailyScore/2)),4))
    }

    fun initComponents(){
        vGym=findViewById(R.id.view2)
        vMoney=findViewById(R.id.view3)
        vSleep=findViewById(R.id.view4)
        vLearn=findViewById(R.id.view)
        btnblau=findViewById(R.id.bEditGoals)
        perfil= findViewById(R.id.profile)
        task= findViewById(R.id.task)
        goal= findViewById(R.id.goal)
        grow= findViewById(R.id.grow)
        ivPerfil=findViewById(R.id.imageView)
        tvDaily=findViewById(R.id.tvDailyScore)
        tvTotal=findViewById(R.id.tvScore)
        tvUser=findViewById(R.id.tvUser)
        ivFire=findViewById(R.id.ivFire)
        tvUser.setText("Hola "+username)
        tvTotal.setText(totalScore.toString())
        tvDaily.setText(dailyScore.toString())
        when (clase){
            "ASESINO"->{ivPerfil.setImageResource(R.drawable.asessi)}
            "GUERRERO"->{ivPerfil.setImageResource(R.drawable.guerrer)}
            "MAGO"->{ivPerfil.setImageResource(R.drawable.mag)}
            "COMERCIANTE"->{ivPerfil.setImageResource(R.drawable.ric)}
        }
    }
    fun initListeners(){
        perfil.setOnClickListener {
            navigateToProfile()
        }
        ivPerfil.setOnClickListener(){
            navigateToProfile()
        }
        goal.setOnClickListener {
            val intent = Intent(this, Goals::class.java)
            startActivity(intent)
        }
        btnblau.setOnClickListener{
            val intent = Intent(this, EditGoals::class.java)
            startActivity(intent)
        }
        vGym.setOnClickListener{
            val intent = Intent(this, ActivityGym::class.java)
            startActivity(intent)
        }
        vLearn.setOnClickListener{

        }
        vMoney.setOnClickListener{

        }
        vSleep.setOnClickListener{

        }
    }
    private fun check_all(){
        tvLvl=findViewById(R.id.tvLvl)
        pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        editor = pref.edit()
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val fechaActual: String = dateFormat.format(Date())
        editor.putString("ultimaFechaJugada", fechaActual)
        editor.apply()
        username=pref.getString("username", "user")!!
        dailyScore=pref.getInt("dailyScore",0)
        racha=pref.getInt("racha",1)
        totalScore=pref.getInt("totalScore",0)
        clase=pref.getString("CLASS","none")!!
        lvl=pref.getInt("lvl",1)
        exp=pref.getInt("exp",0)

        tvLvl.text = lvl.toString()
        if (clase=="A"){
            editor.putString("CLASS","ASESINO")
            editor.apply()
            clase="ASESINO"
        }else if (clase=="G"){
            editor.putString("CLASS","GUERRERO")
            clase="GUERRERO"
            editor.apply()
        }else if (clase=="M"){
            editor.putString("CLASS","MAGO")
            clase="MAGO"
            editor.apply()
        }else if (clase=="C"){
            editor.putString("CLASS","COMERCIANTE")
            clase="COMERCIANTE"
            editor.apply()
        }else if (clase=="none"){
            val intent = Intent(this, ActivityClass::class.java)
            startActivity(intent)
        }
    }
    private fun navigateToProfile() {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }

    private fun configurarAlarmaReinicioDiario() {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar[Calendar.HOUR_OF_DAY] = 0
        calendar[Calendar.MINUTE] = 0
        calendar[Calendar.SECOND] = 0
        val intent = Intent(this, ReinicioDiarioService::class.java)
        val pendingIntent =
            PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        // Configurar el reinicio diario a la medianoche
        alarmManager?.setInexactRepeating(
            AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent
        )
    }
}