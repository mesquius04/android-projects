package com.nihoi.calculadoranotestall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.lang.Double.min
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var isBatSelected: Boolean = true
    private var isCFGMSelected: Boolean = false

    private var notaBatCF: Float = 0f

    private var currentAge: Float = 0.1f
    private var currentHeight: Float = 0.1f
    private var nota:Double=0.0
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var editText5: EditText
    private lateinit var editTextes1: EditText
    private lateinit var editTextes2: EditText
    private lateinit var llenguaextra:LinearLayout
    private lateinit var viewGeneral:CardView
    private lateinit var viewMale: CardView
    private lateinit var viewCoofi: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button
    private lateinit var tvNotaMitjana: TextView
    private lateinit var checkBox:CheckBox
    companion object{
        const val IMC_KEY = "IMC_RESULT"
        const val IMC_KEYY = "IMC_RESULTT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initUI()
    }


    private fun initComponents() {
        llenguaextra=findViewById(R.id.llenguaextra)
        checkBox = findViewById(R.id.checkbox_id)
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        viewGeneral = findViewById(R.id.viewHeight)
        tvHeight = findViewById(R.id.tvHeight)
        viewCoofi=findViewById(R.id.viewCoofi)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnEspLess1)
        btnPlusWeight = findViewById(R.id.btnEspPlus1)
        tvWeight = findViewById(R.id.tvEsp1)
        btnSubtractAge = findViewById(R.id.btnEspLess2)
        btnPlusAge = findViewById(R.id.btnEspPlus2)
        tvAge = findViewById(R.id.tvEsp2)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvNotaMitjana=findViewById(R.id.tvNotaMitjana)
        editText1 = findViewById(R.id.EditText1)
        editText2 = findViewById(R.id.EditText2)
        editText3 = findViewById(R.id.EditText3)
        editText4 = findViewById(R.id.EditText4)
        editText5 = findViewById(R.id.EditText5)
        editTextes1 = findViewById(R.id.EditTextes1)
        editTextes2 = findViewById(R.id.EditTextes2)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeCourse()
            tvNotaMitjana.setText(R.string.notaBat)
            viewGeneral.visibility= View.VISIBLE
            viewCoofi.visibility=View.VISIBLE
            setCourseColor()
        }
        viewFemale.setOnClickListener {
            changeCourse()
            viewCoofi.visibility=View.GONE
            viewGeneral.visibility= View.GONE
            tvNotaMitjana.setText(R.string.notaCF)
            setCourseColor()
        }
        checkBox.setOnCheckedChangeListener { _, isChecked: Boolean ->
            if (checkBox.isChecked) {
                checkBox.isChecked =true
                llenguaextra.visibility=View.VISIBLE
                checkBox.setBackgroundResource(R.color.background_fab) // Cambia a fondo rojo cuando se marca
            } else {
                checkBox.isChecked =false
                llenguaextra.visibility=View.GONE
                checkBox.setBackgroundResource(R.color.black) // Cambia a fondo azul cuando se desmarca
            }
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val formattedValue = value.toString().replace(",", ".")
            notaBatCF = formattedValue.toFloat()
            tvHeight.text = "$notaBatCF"
        }
        btnPlusWeight.setOnClickListener {
            if (currentHeight+0.1<=0.25){
                currentHeight += 0.1f
            }
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            if (currentHeight-0.1>=0){
                currentHeight -= 0.1f
            }
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            if (currentAge+0.1<=0.25){
                currentAge += 0.1f
            }
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            if (currentAge-0.1>=0){
                currentAge -= 0.1f
            }
            setAge()
        }
        btnCalculate.setOnClickListener {
            var result = calculateNotaTall()
            var resultGeneral = calculateNotaGeneral()
            navigateToResult(result,resultGeneral)
        }
    }

    private fun navigateToResult(result: Double,general:Double) {
        val intent = Intent(this, ResultatActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        intent.putExtra(IMC_KEYY, general)
        startActivity(intent)
    }
    private fun calculateNotaGeneral():Double {
        if (isBatSelected && checkBox.isChecked){
            val df = DecimalFormat("#.###")
            var e1= editText1.text.toString().replace(",",".")
            var e2= editText2.text.toString().replace(",",".")
            var e3= editText3.text.toString().replace(",",".")
            var e4= editText4.text.toString().replace(",",".")
            var e5= editText5.text.toString().replace(",",".")
            if (e1.isBlank()) {e1="0"
                editText1.setText("0")}
            if (e2.isBlank()) {e2="0"
                editText2.setText("0")}
            if (e3.isBlank()) {e3="0"
                editText3.setText("0")}
            if (e4.isBlank()) {e4="0"
                editText4.setText("0")}
            if (e5.isBlank()) {e5="0"
                editText5.setText("0")}
            val nota : Double = ((min(e1.toDouble(),10.0)+min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/5+notaBatCF*0.6)
            return df.format(nota).toString().replace(",",".").toDouble()
        }else if (isBatSelected) {
            val df = DecimalFormat("#.###")
            var e2= editText2.text.toString().replace(",",".")
            var e3= editText3.text.toString().replace(",",".")
            var e4= editText4.text.toString().replace(",",".")
            var e5= editText5.text.toString().replace(",",".")
            if (e2.isBlank()) {e2="0"
                editText2.setText("0")}
            if (e3.isBlank()) {e3="0"
                editText3.setText("0")}
            if (e4.isBlank()) {e4="0"
                editText4.setText("0")}
            if (e5.isBlank()) {e5="0"
                editText5.setText("0")}
            val nota : Double = ((min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/4+notaBatCF*0.6)
            return df.format(nota).toString().replace(",",".").toDouble()
            } else {
            return notaBatCF.toDouble()
        }

    }
    private fun calculateNotaTall():Double {
        if (isBatSelected && checkBox.isChecked){
            val df = DecimalFormat("#.###")
            var e1= editText1.text.toString().replace(",",".")
            var e2= editText2.text.toString().replace(",",".")
            var e3= editText3.text.toString().replace(",",".")
            var e4= editText4.text.toString().replace(",",".")
            var e5= editText5.text.toString().replace(",",".")

            var et1= editTextes1.text.toString().replace(",",".")
            var et2= editTextes2.text.toString().replace(",",".")

            if (e1.isBlank()) {e1="0"}
            if (e2.isBlank()) {e2="0"}
            if (e3.isBlank()) {e3="0"}
            if (e4.isBlank()) {e4="0"}
            if (e5.isBlank()) {e5="0"}
            if (et1.isBlank()) {et1="0"
                editTextes1.setText("0")}
            if (et2.isBlank()) {et2="0"
                editTextes2.setText("0")}

            if (et1.toDouble()>=5 && et2.toDouble()>=5){
                nota = (((min(e1.toDouble(),10.0)+min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/5+notaBatCF*0.6)+(min(et1.toDouble(),10.0)*currentHeight.toDouble())+(min(et2.toDouble(),10.0)*currentAge.toDouble()))
            }
            else if (et1.toDouble()>=5){
                nota = (((min(e1.toDouble(),10.0)+min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/5+notaBatCF*0.6)+(min(et1.toDouble(),10.0)*currentHeight.toDouble()))
            }
            else if (et2.toDouble()>=5){
                nota = (((min(e1.toDouble(),10.0)+min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/5+notaBatCF*0.6)+(min(et2.toDouble(),10.0)*currentAge.toDouble()))
            }else{
                nota = (((min(e1.toDouble(),10.0)+min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/5+notaBatCF*0.6))
            }
            return df.format(nota).replace(",",".").toDouble()
        }else if (isBatSelected){
            val df = DecimalFormat("#.###")
            var e2= editText2.text.toString().replace(",",".")
            var e3= editText3.text.toString().replace(",",".")
            var e4= editText4.text.toString().replace(",",".")
            var e5= editText5.text.toString().replace(",",".")

            var et1= editTextes1.text.toString().replace(",",".")
            var et2= editTextes2.text.toString().replace(",",".")

            if (e2.isBlank()) {e2="0"}
            if (e3.isBlank()) {e3="0"}
            if (e4.isBlank()) {e4="0"}
            if (e5.isBlank()) {e5="0"}
            if (et1.isBlank()) {et1="0"
                editTextes1.setText("0")}
            if (et2.isBlank()) {et2="0"
                editTextes2.setText("0")}

            if (et1.toDouble()>=5 && et2.toDouble()>=5){
                nota = (((min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/4+notaBatCF*0.6)+(min(et1.toDouble(),10.0)*currentHeight.toDouble())+(min(et2.toDouble(),10.0)*currentAge.toDouble()))
            }
            else if (et1.toDouble()>=5){
                nota = (((min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/4+notaBatCF*0.6)+(min(et1.toDouble(),10.0)*currentHeight.toDouble()))
            }
            else if (et2.toDouble()>=5){
                nota = (((min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/4+notaBatCF*0.6)+(min(et2.toDouble(),10.0)*currentAge.toDouble()))
            }else{
                nota = (((min(e2.toDouble(),10.0)+min(e3.toDouble(),10.0)+min(e4.toDouble(),10.0)+min(e5.toDouble(),10.0))*0.4/4+notaBatCF*0.6))
            }
            return df.format(nota).replace(",",".").toDouble()
        }else{
            val df = DecimalFormat("#.###")

            var et1= editTextes1.text.toString().replace(",",".")
            var et2= editTextes2.text.toString().replace(",",".")
            if (et1.isBlank()) {et1="0"}
            if (et2.isBlank()) {et2="0"}
            val nota : Double = (notaBatCF+(min(et1.toDouble(),10.0)*currentHeight.toDouble())+(min(et2.toDouble(),10.0)*currentAge.toDouble()))
            return df.format(nota).replace(",",".").toDouble()
        }


    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentHeight.toString()
    }

    private fun changeCourse() {
        isBatSelected = !isBatSelected
        isCFGMSelected = !isCFGMSelected
    }

    private fun setCourseColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isBatSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isCFGMSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }


    private fun initUI() {
        setCourseColor()
        setWeight()
        setAge()
    }

}