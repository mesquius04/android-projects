package com.nihoi.jocestiu
import android.app.Activity
import android.content.Intent
import java.util.Random
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.nihoi.jocestiu.structures.Player
import com.nihoi.jocestiu.structures.Element
import com.nihoi.jocestiu.structures.Skill
import com.nihoi.jocestiu.structures.Spirit

class GetExp : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_EXP = 1
    }
    var lvl: Int = 0
    var prevexp: Int = 0
    var dmg: Int =0
    var def: Int =0
    var vel: Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lvl=intent.getIntExtra("lvl",1)
        prevexp=intent.getIntExtra("exp",0)
        setContentView(R.layout.activity_get_exp)
        val exp1=findViewById<ImageButton>(R.id.exp1)
        val exp2=findViewById<ImageButton>(R.id.exp2)
        val exp3=findViewById<ImageButton>(R.id.exp3)
        val exp4=findViewById<ImageButton>(R.id.exp4)
        val check=findViewById<Button>(R.id.check)
        val victory=findViewById<LinearLayout>(R.id.victory)
        val waifu=findViewById<ImageView>(R.id.waifu)
        val resum=findViewById<ImageButton>(R.id.resum)
        var answers = IntArray(10) { 0 }
        var frases = MutableList(10) { "0" }
        var exp=0
        var diff=0
        var truee=0
        var falsee=0

        val victoria =findViewById<TextView>(R.id.victoria)
        val extrastats =findViewById<TextView>(R.id.extrastats)
        val extralvl =findViewById<TextView>(R.id.extralvl)

        val r1=findViewById<EditText>(R.id.et1)
        val r2=findViewById<EditText>(R.id.et2)
        val r3=findViewById<EditText>(R.id.et3)
        val r4=findViewById<EditText>(R.id.et4)
        val r5=findViewById<EditText>(R.id.et5)
        val r6=findViewById<EditText>(R.id.et6)
        val r7=findViewById<EditText>(R.id.et7)
        val r8=findViewById<EditText>(R.id.et8)
        val r9=findViewById<EditText>(R.id.et9)
        val r10=findViewById<EditText>(R.id.et10)

        val exercici=findViewById<LinearLayout>(R.id.exercici)
        val ex1=findViewById<TextView>(R.id.ex1)
        val ex2=findViewById<TextView>(R.id.ex2)
        val ex3=findViewById<TextView>(R.id.ex3)
        val ex4=findViewById<TextView>(R.id.ex4)
        val ex5=findViewById<TextView>(R.id.ex5)
        val ex6=findViewById<TextView>(R.id.ex6)
        val ex7=findViewById<TextView>(R.id.ex7)
        val ex8=findViewById<TextView>(R.id.ex8)
        val ex9=findViewById<TextView>(R.id.ex9)
        val ex10=findViewById<TextView>(R.id.ex10)

        val butons=findViewById<LinearLayout>(R.id.buttons)
        val texts=findViewById<LinearLayout>(R.id.texts)
        exp1.setOnClickListener{
            butons.visibility= View.GONE
            texts.visibility=View.GONE
            exercici.visibility=View.VISIBLE
            var i=0
            diff=1
            while (i<10){
                val random = Random()
                val randomNumber1 = random.nextInt(20)+1
                val randomNumber2 = random.nextInt(20)+1
                val op = random.nextInt(4)+1
                if (op==1){
                    val operacio= randomNumber1.toString()+" + "+randomNumber2.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1+randomNumber2
                }
                else if (op==2){
                    if (randomNumber1>=randomNumber2){
                        val operacio= randomNumber1.toString()+" - "+randomNumber2.toString()
                        frases[i]=operacio
                        answers[i]=randomNumber1-randomNumber2
                    }
                    else if (randomNumber1<randomNumber2){
                        val operacio= randomNumber2.toString()+" - "+randomNumber1.toString()
                        frases[i]=operacio
                        answers[i]=randomNumber2-randomNumber1
                    }
                }
                else if (op==3){
                    val operacio= randomNumber1.toString()+" x "+randomNumber2.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1*randomNumber2
                }
                else if (op==4){
                    val operacio= randomNumber1.toString()+" / "+randomNumber2.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1/randomNumber2
                }
                i++
            }
            ex1.setText(frases[0])
            ex2.setText(frases[1])
            ex3.setText(frases[2])
            ex4.setText(frases[3])
            ex5.setText(frases[4])
            ex6.setText(frases[5])
            ex7.setText(frases[6])
            ex8.setText(frases[7])
            ex9.setText(frases[8])
            ex10.setText(frases[9])
        }

        exp2.setOnClickListener{
            butons.visibility= View.GONE
            texts.visibility=View.GONE
            exercici.visibility=View.VISIBLE
            var i=0
            diff=2
            while (i<10){
                val random = Random()
                val randomNumber1 = random.nextInt(50)+1
                val randomNumber2 = random.nextInt(50)+1
                val op = random.nextInt(4)+1
                if (op==1){
                    val operacio= randomNumber1.toString()+" + "+randomNumber2.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1+randomNumber2
                }
                else if (op==2){
                    if (randomNumber1>=randomNumber2){
                        val operacio= randomNumber1.toString()+" - "+randomNumber2.toString()
                        frases[i]=operacio
                        answers[i]=randomNumber1-randomNumber2
                    }
                    else if (randomNumber1<randomNumber2){
                        val operacio= randomNumber2.toString()+" - "+randomNumber1.toString()
                        frases[i]=operacio
                        answers[i]=randomNumber2-randomNumber1
                    }
                }
                else if (op==3){
                    val operacio= randomNumber1.toString()+" x "+randomNumber2.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1*randomNumber2
                }
                else if (op==4){
                    val operacio= randomNumber1.toString()+" / "+randomNumber2.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1/randomNumber2
                }
                i++
            }
            ex1.setText(frases[0])
            ex2.setText(frases[1])
            ex3.setText(frases[2])
            ex4.setText(frases[3])
            ex5.setText(frases[4])
            ex6.setText(frases[5])
            ex7.setText(frases[6])
            ex8.setText(frases[7])
            ex9.setText(frases[8])
            ex10.setText(frases[9])
        }

        exp3.setOnClickListener{
            butons.visibility= View.GONE
            texts.visibility=View.GONE
            exercici.visibility=View.VISIBLE
            var i=0
            diff=3
            while (i<10){
                val random = Random()
                val randomNumber1 = random.nextInt(60)+1
                val randomNumber2 = random.nextInt(60)+1
                val randomNumber3 = random.nextInt(70)+1
                val op = random.nextInt(4)+1
                if (op==1){
                    val operacio= randomNumber1.toString()+" + "+randomNumber2.toString()+" + "+randomNumber3.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1+randomNumber2+randomNumber3
                }
                else if (op==2){
                    if (randomNumber1+randomNumber3>=randomNumber2){
                        val operacio= randomNumber1.toString()+" + "+randomNumber3.toString()+" - "+randomNumber2.toString()
                        frases[i]=operacio
                        answers[i]=randomNumber1+randomNumber3-randomNumber2
                    }
                    else{
                        val operacio= randomNumber2.toString()+" + "+randomNumber3.toString()+" - "+randomNumber1.toString()
                        frases[i]=operacio
                        answers[i]=randomNumber2+randomNumber3-randomNumber1
                    }
                }
                else if (op==3){
                    val operacio= randomNumber1.toString()+" x "+randomNumber2.toString()+" + "+randomNumber3.toString()
                    frases[i]=operacio
                    answers[i]=randomNumber1*randomNumber2+randomNumber3
                }
                else if (op==4){
                    val operacio= randomNumber1.toString()+" / "+randomNumber2.toString()+" x "+randomNumber3.toString()
                    frases[i]=operacio
                    answers[i]=(randomNumber1/randomNumber2)*randomNumber3
                }
                i++
            }
            ex1.setText(frases[0])
            ex2.setText(frases[1])
            ex3.setText(frases[2])
            ex4.setText(frases[3])
            ex5.setText(frases[4])
            ex6.setText(frases[5])
            ex7.setText(frases[6])
            ex8.setText(frases[7])
            ex9.setText(frases[8])
            ex10.setText(frases[9])
        }

        check.setOnClickListener {
            if (answers[0]==r1.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[1]==r2.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[2]==r3.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[3]==r4.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[4]==r5.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[5]==r6.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[6]==r7.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[7]==r8.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[8]==r9.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            if (answers[9]==r10.text.toString().toInt()){
                exp+=(10*diff*diff)
                truee++
            }
            Log.d("FIRST EXP",prevexp.toString())
            prevexp+=exp
            Log.d("FIRST EXP",prevexp.toString())
            val random = Random()
            var lvlincrease=0
            while (prevexp>=lvl*lvl*10){
                prevexp-=lvl*lvl*10
                lvl++
                lvlincrease++
                dmg+= random.nextInt(4)+5
                def+= random.nextInt(4)+5
                vel+= random.nextInt(4)+5
            }
            dmg+= random.nextInt(2)+diff
            def+= random.nextInt(2)+diff
            vel+= random.nextInt(2)+diff

            victoria.setText(truee.toString()+" / 10")
            extrastats.setText("+"+dmg.toString()+" ATK   +"+def.toString()+" DEF\n   +"+vel.toString()+" VEL   ")
            extralvl.setText("+"+lvlincrease.toString()+" LVL    +"+exp.toString()+" EXP")
            resum.visibility=View.VISIBLE
            waifu.visibility=View.VISIBLE
            victory.visibility=View.VISIBLE
            exercici.visibility=View.GONE

    }
        resum.setOnClickListener {
            ex1.setText("")
            ex2.setText("")
            ex3.setText("")
            ex4.setText("")
            ex5.setText("")
            ex6.setText("")
            ex7.setText("")
            ex8.setText("")
            ex9.setText("")
            ex10.setText("")
            r1.setText("")
            r2.setText("")
            r3.setText("")
            r4.setText("")
            r5.setText("")
            r6.setText("")
            r7.setText("")
            r8.setText("")
            r9.setText("")
            r10.setText("")
            truee=0
            exp=0
            butons.visibility= View.VISIBLE
            texts.visibility=View.VISIBLE
            resum.visibility=View.GONE
            waifu.visibility=View.GONE
            victory.visibility=View.GONE
        }
    }
    override fun onBackPressed() {
        val intent = Intent(this@GetExp, MainActivity::class.java)
        intent.putExtra("lvl", lvl)
        intent.putExtra("exp", prevexp)
        intent.putExtra("dmg",dmg)
        intent.putExtra("def",def)
        intent.putExtra("vel",vel)
        setResult(Activity.RESULT_OK, intent)
        super.onBackPressed()
        finish()
    }



}