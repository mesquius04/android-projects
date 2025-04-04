package com.nihoi.childtoman

import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.lang.Double.min
import java.text.DecimalFormat
import  android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.slider.RangeSlider
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.properties.Delegates


class EditGoals : AppCompatActivity(){
    var total =0
    var daily=0
    var etapa=1
    var gymSc=0
    var learnSc=0
    var moneySc=0
    var sleepSc=0
    var reto=0
    var par1=0
    var par2=0
    var par3=0
    var par4=0
    var gymtoday=false
    var learntoday=false
    var moneytoday=false

    var fuerzaday by Delegates.notNull<Boolean>()
    lateinit var clase : String
    lateinit var ivback : ImageView
    lateinit var tvEtapa : TextView
    lateinit var ivnext : ImageView
    lateinit var gym : ConstraintLayout
    lateinit var learn : ConstraintLayout
    lateinit var money : ConstraintLayout
    lateinit var sleep : ConstraintLayout
    lateinit var progresbar: ProgressBar
    lateinit var resum : ConstraintLayout
    lateinit var tvdiaris:TextView
    private lateinit var forca: ImageView
    private lateinit var agilitat: ImageView
    private lateinit var gymsi: ImageView
    private lateinit var gymno: ImageView
    private lateinit var gym2: RangeSlider
    private lateinit var gym3: RangeSlider
    private lateinit var gym4: RangeSlider

    private lateinit var learn2: RangeSlider
    private lateinit var learn3: RangeSlider
    private lateinit var learn4: RangeSlider
    private lateinit var learnsi: ImageView
    private lateinit var learnno: ImageView
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private lateinit var money2: RangeSlider
    private lateinit var money3: RangeSlider
    private lateinit var money4: RangeSlider
    private lateinit var moneysi: ImageView
    private lateinit var moneyno: ImageView
    lateinit var tvScore : TextView
    private lateinit var sleep1: RangeSlider
    private lateinit var sleep2: RangeSlider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_goals)
        initVariables()
        initListeners()
    }

    fun initVariables(){
        pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        editor = pref.edit()
        daily =pref.getInt("dailyScore",0)
        total =pref.getInt("totalScore",0)
        clase=pref.getString("CLASS","none")!!
        ivback=findViewById(R.id.ivback)
        ivnext=findViewById(R.id.ivnext)
        gym=findViewById(R.id.gym)
        learn=findViewById(R.id.learn)
        money=findViewById(R.id.money)
        sleep=findViewById(R.id.sleep)
        tvEtapa=findViewById(R.id.tvEtapaGoals)
        progresbar=findViewById(R.id.progressBar)
        resum=findViewById(R.id.resumen)
        forca=findViewById(R.id.ivGUE)
        agilitat=findViewById(R.id.ivASS)
        gymsi=findViewById(R.id.ivYES)
        gymno=findViewById(R.id.ivNO)
        learnsi=findViewById(R.id.ivYES2)
        learnno=findViewById(R.id.ivNO2)
        moneysi=findViewById(R.id.ivYES3)
        moneyno=findViewById(R.id.ivNO3)
        tvScore=findViewById(R.id.textView22)
        gym2=findViewById(R.id.rsMinutsGYM)
        gym3=findViewById(R.id.rsIntensitatGym)
        gym4=findViewById(R.id.rsImportanciaG)

        gym4.isEnabled = false

        learn2=findViewById(R.id.rsMinutsL)
        learn3=findViewById(R.id.rsIntensitatL)
        learn4=findViewById(R.id.rsImportanciaL)

        learn4.isEnabled = false

        money2=findViewById(R.id.rsMinutsM)
        money3=findViewById(R.id.rsIntensitatM)
        money4=findViewById(R.id.rsImportanciaM)

        money4.isEnabled = false

        tvdiaris=findViewById(R.id.tcdiaris)
        tvdiaris.setText(reto.toString()+" TC")
        sleep2=findViewById(R.id.rsMinutsS)
        sleep1=findViewById(R.id.rsImportanciaS)

    }
    fun initListeners(){
        ivnext.setOnClickListener(){
            if (etapa<4){
                ivback.visibility=View.VISIBLE
                tvEtapa.text=(etapa+1).toString()+"/4"
                progresbar.progress=(etapa+1)*25
            }
            when(etapa){
                1->{gym.visibility=View.GONE
                    if (gymtoday){
                        gymSc=(par3*par4*par2/105)
                        reto+=gymSc
                    }else{gymtoday=false}

                    tvdiaris.setText(reto.toString()+" TC")
                    etapa++
                    importancia()
                    learn.visibility=View.VISIBLE
                }
                2->{learn.visibility=View.GONE
                    if (learntoday){
                        learnSc=(par3*par4*par2/95)
                        reto+=learnSc
                    }else{learntoday=false}
                    tvdiaris.setText(reto.toString()+" TC")
                    etapa++
                    importancia()
                    money.visibility=View.VISIBLE
                }
                3->{money.visibility=View.GONE
                    if (moneytoday){
                        moneySc=(par3*par4*par2/100).toInt()
                        reto+=moneySc
                    }else{moneytoday=false}
                    tvdiaris.setText(reto.toString()+" TC")
                    etapa++
                    importancia()
                    sleep.visibility=View.VISIBLE
                }
                4->{resum.visibility=View.VISIBLE
                    if (par2>=7 && par2<=10){
                        sleepSc=5
                    }else if (par1+par2>=7 && par1+par2<=11){
                        sleepSc=3
                    }else if (par1+par2>=11){
                        sleepSc=1
                    }else {
                        sleepSc=0
                    }
                    reto+=sleepSc
                    tvdiaris.setText(reto.toString()+" TC")
                    tvScore.setText(reto.toString()+" TC's")
                    etapa++
                    sleep.visibility=View.GONE
                }
                5->{
                    var intent = Intent(this, MainActivity::class.java)
                    var increaselvl=false
                    var current= pref.getInt("totalScore",0)
                    var daily= pref.getInt("dailyScore",0)
                    var exp= pref.getInt("exp",0)
                    var lvl=pref.getInt("lvl",1)
                    var racha=pref.getInt("racha",1)
                    exp+=(gymSc+learnSc+moneySc+sleepSc)/2*racha
                    while(exp>((lvl*30+20))){
                        editor.putInt("prevlvl",lvl)
                        exp-=(lvl*30+20)
                        lvl++
                        increaselvl=true
                    }
                    current+=gymSc+learnSc+moneySc+sleepSc
                    daily+=gymSc+learnSc+moneySc+sleepSc
                    editor.putInt("lvl",lvl)
                    editor.putInt("exp",exp)
                    editor.putInt("totalScore",current)
                    editor.putInt("dailyScore",daily)
                    editor.apply()
                    if(increaselvl){
                        intent = Intent(this, ActivityLvlUp::class.java)
                    }
                    startActivity(intent)
                }
            }
        }

        gymsi.setOnClickListener{
            gymsi.setBackgroundResource(R.drawable.objetivoo)
            gymno.setBackgroundResource(R.drawable.lighttitle)
            gymtoday=true
        }
        gymno.setOnClickListener{
            gymno.setBackgroundResource(R.drawable.objetivoo)
            gymsi.setBackgroundResource(R.drawable.lighttitle)
            gymtoday=false
            fuerzaday=false
        }
        learnsi.setOnClickListener{
            learnsi.setBackgroundResource(R.drawable.objetivoo)
            learnno.setBackgroundResource(R.drawable.lighttitle)
            learntoday=true
        }
        learnno.setOnClickListener{
            learnno.setBackgroundResource(R.drawable.objetivoo)
            learnsi.setBackgroundResource(R.drawable.lighttitle)
            learntoday=false
        }
        moneysi.setOnClickListener{
            moneysi.setBackgroundResource(R.drawable.objetivoo)
            moneyno.setBackgroundResource(R.drawable.lighttitle)
            moneytoday=true
        }
        moneyno.setOnClickListener{
            moneyno.setBackgroundResource(R.drawable.objetivoo)
            moneysi.setBackgroundResource(R.drawable.lighttitle)
            moneytoday=false
        }
        forca.setOnClickListener{
            forca.setBackgroundResource(R.drawable.objetivoo)
            agilitat.setBackgroundResource(R.drawable.lighttitle)
            fuerzaday=true
            importancia()
        }
        agilitat.setOnClickListener{
            agilitat.setBackgroundResource(R.drawable.objetivoo)
            forca.setBackgroundResource(R.drawable.lighttitle)
            fuerzaday=false
            importancia()
        }

        ivback.setOnClickListener{
            etapa--
            if (etapa<4){
                ivback.visibility=View.VISIBLE
                tvEtapa.text=etapa.toString()+"/4"
                progresbar.progress=etapa*25
            }
            when(etapa){
                1->{gym.visibility=View.VISIBLE
                    reto-=gymSc
                    importancia()
                    learn.visibility=View.GONE
                    ivback.visibility=View.GONE
                    tvdiaris.setText(reto.toString()+" TC")
                }
                2->{learn.visibility=View.VISIBLE
                    money.visibility=View.GONE
                    reto-=learnSc
                    importancia()
                    tvdiaris.setText(reto.toString()+" TC")
                }
                3->{money.visibility=View.VISIBLE
                    reto-=moneySc
                    importancia()
                    sleep.visibility=View.GONE
                    tvdiaris.setText(reto.toString()+" TC")
                }
                4->{resum.visibility=View.GONE
                    sleep.visibility=View.VISIBLE
                    reto-=sleepSc
                    importancia()
                    tvdiaris.setText(reto.toString()+" TC")
                }
            }
        }
        gym2.addOnChangeListener { _, value, _ ->
            par2= value.toInt()
        }
        gym3.addOnChangeListener { _, value, _ ->
            par3= value.toInt()
        }
        learn2.addOnChangeListener { _, value, _ ->
            par2= value.toInt()
        }
        learn3.addOnChangeListener { _, value, _ ->
            par3= value.toInt()
        }
        money2.addOnChangeListener { _, value, _ ->
            par2= value.toInt()
        }
        money3.addOnChangeListener { _, value, _ ->
            par3= value.toInt()
        }
        sleep1.addOnChangeListener { _, value, _ ->
            par1= value.toInt()
        }
        sleep2.addOnChangeListener { _, value, _ ->
            par2= value.toInt()
        }
    }
    private fun importancia(){
        when (clase){
            "ASESINO"->{
                when(etapa){
                    1->{gym4.isEnabled = true
                        if (fuerzaday){
                            gym4.values = listOf(3.0f)
                            par4=3
                        }else{
                            gym4.values = listOf(5.0f)
                            par4=5}
                        gym4.isEnabled = false
                    }
                    2-> {
                        learn4.isEnabled = true
                        learn4.values = listOf(3.0f)
                        par4 = 3
                        learn4.isEnabled = false
                    }
                    3->{
                        money4.isEnabled = true
                        money4.values = listOf(2.0f)
                        money4.isEnabled = false
                    }
                }
            }
        }
    }
}