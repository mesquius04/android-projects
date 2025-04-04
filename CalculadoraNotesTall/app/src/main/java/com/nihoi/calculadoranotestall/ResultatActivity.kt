package com.nihoi.calculadoranotestall
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.nihoi.calculadoranotestall.MainActivity.Companion.IMC_KEY
import com.nihoi.calculadoranotestall.MainActivity.Companion.IMC_KEYY
import java.text.DecimalFormat
import kotlin.math.abs

class ResultatActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvNotaPerCent:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button
    private lateinit var resultatnota:CardView
    private lateinit var grafic:CardView
    private lateinit var tview1:TextView
    private lateinit var tview2:TextView
    private lateinit var tview3:TextView
    private lateinit var tview4:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val df = DecimalFormat("#.###")
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        val general:Double = intent.extras?.getDouble(IMC_KEYY) ?: -1.0
        initComponents()
        tview4.setText(df.format(general).toString())
        tview4.layoutParams.height = ((200*general)/10).toInt()
        tview3.layoutParams.height = 136
        tview2.layoutParams.height = 137
        tview1.layoutParams.height = 137

        tview4.requestLayout()
        initUI(result,general)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed()}
        resultatnota.setOnClickListener {
            resultatnota.visibility=View.GONE
            grafic.visibility=View.VISIBLE
        }
        grafic.setOnClickListener {
            grafic.visibility=View.GONE
            resultatnota.visibility=View.VISIBLE
        }

    }

    private fun initUI(result: Double,general: Double) {
        tvIMC.text = result.toString()
        tvDescription.text=String.format("%.2f", (general))+" + "+String.format("%.2f", abs(result-general))
        if (general<5){
            tvResult.setText(R.string.nota_moltbaixa)
        }
        else if (result<9){
            tvResult.setText(R.string.nota_baixa)
        }
        else if (result<11){
            tvResult.setText(R.string.nota_mitjana)
        }
        else if (result<13){
            tvResult.setText(R.string.nota_alta)
        }
        else if (result<=14){
            tvResult.setText(R.string.nota_moltalta)
        }
        when(general){
            in 0.0..0.5->tvNotaPerCent.setText("100%")
            in 0.5..1.0->tvNotaPerCent.setText("99,69%")
            in 1.0..1.5->tvNotaPerCent.setText("99,68%")
            in 1.5..2.0->tvNotaPerCent.setText("99,67%")

            in 2.0..2.5->tvNotaPerCent.setText("99,61%")
            in 2.5..3.0->tvNotaPerCent.setText("99,50%")
            in 3.0..3.5->tvNotaPerCent.setText("99,22%")
            in 3.5..4.0->tvNotaPerCent.setText("98,52%")

            in 4.0..4.5->tvNotaPerCent.setText("97,25%")
            in 4.5..5.0->tvNotaPerCent.setText("94,53%")
            in 5.0..5.5->tvNotaPerCent.setText("89,67%")
            in 5.5..6.0->tvNotaPerCent.setText("82,38%")

            in 6.0..6.5->tvNotaPerCent.setText("72,02%")
            in 6.5..7.0->tvNotaPerCent.setText("59,63%")
            in 7.0..7.5->tvNotaPerCent.setText("46,49%")
            in 7.5..8.0->tvNotaPerCent.setText("33,07%")

            in 8.0..8.5->tvNotaPerCent.setText("21,16%")
            in 8.5..9.0->tvNotaPerCent.setText("11,32%")
            in 9.0..9.5->tvNotaPerCent.setText("4,31%")
            in 9.5..10.0->tvNotaPerCent.setText("0,67%")
        }

    }

    private fun initComponents() {
        tview1=findViewById(R.id.tview1)
        tview2=findViewById(R.id.tview2)
        tview3=findViewById(R.id.tview3)
        tview4=findViewById(R.id.tview4)
        tvIMC = findViewById(R.id.tvIMC)
        tvNotaPerCent = findViewById(R.id.textpercen)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
        resultatnota=findViewById(R.id.resultatnota)
        grafic=findViewById(R.id.grafic)
    }
}