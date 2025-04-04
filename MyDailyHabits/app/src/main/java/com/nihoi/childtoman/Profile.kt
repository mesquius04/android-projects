package com.nihoi.childtoman
import androidx.appcompat.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Profile : AppCompatActivity() {
    var total =0
    var daily=0
    lateinit var etUser : EditText
    lateinit var tvNivell : TextView
    lateinit var tvTitul : TextView
    lateinit var progressBar : ProgressBar
    private lateinit var pref : SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var username: String
    private lateinit var objectiu : ImageView
    private lateinit var backtohome : ImageView
    private lateinit var ivCanviClase : ImageView
    private lateinit var totalsc : TextView
    private lateinit var dailysc : TextView
    private lateinit var tvRacha : TextView
    private lateinit var tvBuff : TextView
    private var lvl=1
    private var exp=0
    private var racha=0
    private lateinit var clase : String
    private lateinit var ivPerfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initVar()
        initListeners()
    }
    fun initVar(){
        pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        editor = pref.edit()

        username=pref.getString("username", "user")!!
        daily =pref.getInt("dailyScore",0)
        total =pref.getInt("totalScore",0)
        lvl =pref.getInt("lvl",1)
        racha=pref.getInt("racha",1)
        exp =pref.getInt("exp",0)
        ivCanviClase=findViewById(R.id.ivCanviClase)
        objectiu=findViewById(R.id.imageView12)
        totalsc=findViewById(R.id.textView17)
        dailysc=findViewById(R.id.textView16)
        tvNivell=findViewById(R.id.tvNivell)
        tvTitul=findViewById(R.id.tvTitul)
        progressBar=findViewById(R.id.progressBarLVL)
        backtohome=findViewById(R.id.ivBacktoMain)
        tvRacha=findViewById(R.id.tvRacha)
        tvBuff=findViewById(R.id.tvBuff)
        etUser= findViewById(R.id.editText)
        etUser.setText(username)
        dailysc.text = daily.toString()
        totalsc.text = total.toString()

        ivPerfil=findViewById(R.id.imageView11)
        clase=pref.getString("CLASS","none")!!
        tvRacha.text="- Racha de "+racha.toString()+" día -> "
        tvBuff.text="x"+racha.toString()+" EXP"
        when (clase){
            "ASESINO"->{ivPerfil.setImageResource(R.drawable.asessi)}
            "GUERRERO"->{ivPerfil.setImageResource(R.drawable.guerrer)}
            "MAGO"->{ivPerfil.setImageResource(R.drawable.mag)}
            "COMERCIANTE"->{ivPerfil.setImageResource(R.drawable.ric)}
        }
        progressBar.setMax(lvl*30+20)
        progressBar.setProgress(exp)
        tvNivell.text="NIVEL "+lvl.toString()
        when (lvl){
            in 1..5->{tvTitul.text=getString(R.string.asesinotitulo1)}
            in 6..10->{tvTitul.text=getString(R.string.asesinotitulo2)}
            in 11..15->{tvTitul.text=getString(R.string.asesinotitulo3)}
            in 16..20->{tvTitul.text=getString(R.string.asesinotitulo4)}
            in 21..25->{tvTitul.text=getString(R.string.asesinotitulo5)}
        }
    }
    fun initListeners(){
        ivCanviClase.setOnClickListener(View.OnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this@Profile)
            builder.setTitle("ESTÁS SEGURO?")
                .setMessage("Vas a perder la mitad de tus niveles")
                .setPositiveButton("ACEPTAR",
                    DialogInterface.OnClickListener { dialog, which -> // Realiza la transición a la nueva actividad aquí.
                        startActivity(Intent(this@Profile, ActivityClass::class.java))
                    })
                .setNegativeButton("RECHAZAR",
                    DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
            val dialog: AlertDialog = builder.create()
            dialog.show()
        })

        objectiu.setOnClickListener(){
            username= etUser.text.toString()
            editor.putString("username",username)
            editor.apply()
            val intent = Intent(this, Goals::class.java)
            startActivity(intent)
        }
        backtohome.setOnClickListener(){
            username= etUser.text.toString()
            editor.putString("username",username)
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}