package com.nihoi.jocestiu
import android.app.Activity
import com.nihoi.jocestiu.empty_activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.nihoi.jocestiu.structures.Player
import com.nihoi.jocestiu.structures.Element
import com.nihoi.jocestiu.structures.Skill
import com.nihoi.jocestiu.structures.Spirit
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResult
class MainActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_EXP = 1
        private const val REQUEST_CODE_EXP2 = 2
        private const val REQUEST_CODE_EXP3 = 3
        private const val REQUEST_CODE_EXP4 = 4
    }
    var player=Player(Element.FIRE, 1, 5, 1, 1, 1, 0, 3, 0,"user", null)
    override fun onCreate(savedInstanceState: Bundle?) {
        var pref=getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
        var editor = pref.edit()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mapa=findViewById<ImageButton>(R.id.mapa)
        val dungeon=findViewById<ImageButton>(R.id.dungeon)
        val imageFire=findViewById<ImageButton>(R.id.fire_button)
        val imageWatter=findViewById<ImageButton>(R.id.watter_button)
        val imagePlant=findViewById<ImageButton>(R.id.plant_button)
        val imageEarth=findViewById<ImageButton>(R.id.rock_button)
        val imageThunder=findViewById<ImageButton>(R.id.bold_button)
        val imageIce=findViewById<ImageButton>(R.id.ice_button)
        val fondo1=findViewById<ImageView>(R.id.fondo1)
        val fondo2=findViewById<ImageView>(R.id.fondo2)
        val sect=findViewById<ImageButton>(R.id.sect)

        val nivelx=findViewById<TextView>(R.id.nivelx)
        val progresslvl=findViewById<ProgressBar>(R.id.simpleProgressBar)
        val edituser= findViewById<ImageButton>(R.id.edituser)
        val layoutjoc=findViewById<LinearLayout>(R.id.layoutjoc)
        val layout=findViewById<LinearLayout>(R.id.layoutinicial)
        val me=findViewById<ImageButton>(R.id.element)
        val user=findViewById<TextView>(R.id.player)
        val atktext=findViewById<TextView>(R.id.atk)
        val deftxt=findViewById<TextView>(R.id.def)
        val veltxt=findViewById<TextView>(R.id.spd)
        val sup=findViewById<TextView>(R.id.sup)
        val sub=findViewById<TextView>(R.id.sub)
        val backtxt=findViewById<TextView>(R.id.backtext)
        val back=findViewById<ImageButton>(R.id.back)
        val imageelem=findViewById<ImageView>(R.id.elem2)
        val perfil=findViewById<ImageButton>(R.id.perfil)
        val fondo3=findViewById<ImageView>(R.id.fondo3)
        val layoutperfil=findViewById<LinearLayout>(R.id.layoutperfil)

        val lvlperfil=findViewById<TextView>(R.id.lvlperfil)
        val expperfil=findViewById<TextView>(R.id.expperfil)

        val user1=findViewById<LinearLayout>(R.id.cartellcanvi)
        val user2=findViewById<LinearLayout>(R.id.nom2)
        val canviar=findViewById<Button>(R.id.canviar)
        val editText1=findViewById<EditText>(R.id.edit_text_1)

        var exists=pref.getInt("exists",0)
        var element=pref.getInt("element",10)
        player.lvl=pref.getInt("lvl",1)
        player.progress=pref.getInt("progress",0)
        player.exp=pref.getInt("exp",0)
        Log.d("NEW EXP1", player.exp.toString())
        nivelx.setText("Nivel "+player.lvl.toString())
        progresslvl.setProgress(player.exp)
        progresslvl.max=player.lvl*player.lvl*10

        me.setOnClickListener{
            fondo2.visibility=View.GONE
            layoutjoc.visibility=View.GONE
            fondo3.visibility=View.VISIBLE
            layoutperfil.visibility=View.VISIBLE
            back.visibility=View.VISIBLE
            backtxt.visibility=View.VISIBLE
        }

        val runnable = object : Runnable {
            override fun run() {
                if (exists != 0) {
                    layout.visibility = View.GONE
                    fondo1.visibility = View.GONE
                    fondo2.visibility = View.VISIBLE
                    layoutjoc.visibility = View.VISIBLE

                    var exp = pref.getInt("exp", 0)
                    var dmg = pref.getInt("dmg", 1)
                    var def = pref.getInt("def", 1)
                    var lvl = pref.getInt("lvl", 1)
                    var vel = pref.getInt("vel", 1)
                    var progres= pref.getInt("progress",0)
                    var name = pref.getString("name", "user")
                    if (name == null) {
                        name = "user"
                    }

                    if (element == 0) {
                        me.setBackgroundResource(R.drawable.fire_wisp)
                        imageelem.setBackgroundResource(R.drawable.fire)
                        player = init_player(0, exp, dmg, def, lvl, vel,progres, name)
                        sup.setText("SUPEREFICAZ -> PLANTA y HIELO")
                        sub.setText("DEBIL -> AGUA y TIERRA")
                    } else if (element == 1) {
                        me.setBackgroundResource(R.drawable.elemental_gemstone_water)
                        imageelem.setBackgroundResource(R.drawable.droplet)
                        player = init_player(1, exp, dmg, def, lvl, vel, progres,name)
                        sup.setText("SUPEREFICAZ -> FUEGO y TIERRA")
                        sub.setText("DEBIL -> PLANTA y ELECTRICO")
                    } else if (element == 2) {
                        me.setBackgroundResource(R.drawable.earth_leaf_imp)
                        imageelem.setBackgroundResource(R.drawable.cactus)
                        player = init_player(2, exp, dmg, def, lvl, vel,progres, name)
                        sup.setText("SUPEREFICAZ -> TIERRA y AGUA")
                        sub.setText("DEBIL -> HIELO y FUEGO")
                    } else if (element == 3) {
                        me.setBackgroundResource(R.drawable.earth_wisp)
                        imageelem.setBackgroundResource(R.drawable.rocks)
                        player = init_player(3, exp, dmg, def, lvl, vel,progres, name)
                        sup.setText("SUPEREFICAZ -> FUEGO y ELECTRICO")
                        sub.setText("DEBIL -> AGUA y PLANTA")
                    } else if (element == 4) {
                        me.setBackgroundResource(R.drawable.arcane_orb_thunder)
                        imageelem.setBackgroundResource(R.drawable.thunderbolt_)
                        player = init_player(4, exp, dmg, def, lvl, vel,progres, name)
                        sup.setText("SUPEREFICAZ -> AGUA")
                        sub.setText("DEBIL -> TIERRA")
                    } else if (element == 5) {
                        me.setBackgroundResource(R.drawable.ice_whisp)
                        imageelem.setBackgroundResource(R.drawable.snowflake)
                        player = init_player(5, exp, dmg, def, lvl, vel,progres, name)
                        sup.setText("SUPEREFICAZ -> PLANTA")
                        sub.setText("DEBIL -> FUEGO")
                    }
                    user.setText(player.name)
                    progresslvl.max=player.lvl*player.lvl*10
                    progresslvl.setProgress(player.exp)
                    lvlperfil.setText("Nivel "+player.lvl.toString())
                    expperfil.setText("Exp "+player.exp.toString())
                    user.setText(player.name)
                    atktext.setText("ATK = "+player.dmg.toString())
                    deftxt.setText("DEF = "+player.def.toString())
                    veltxt.setText("SPD = "+player.vel.toString())
                    nivelx.setText("Nivel "+player.lvl.toString())
                    player.lvl=pref.getInt("lvl",1)
                    Log.d("NEW EXP2", player.exp.toString())
                    player.exp=pref.getInt("exp",0)
                    Log.d("NEW EXP3", player.exp.toString())

                    canviar.setOnClickListener{
                        user1.visibility=View.GONE
                        user2.visibility=View.GONE
                        player.name = editText1.text.toString()
                        user.setText(player.name)
                        layoutperfil.visibility=View.VISIBLE
                        editor.putString("name",player.name)
                        editor.apply()
                        back.visibility=View.VISIBLE
                        backtxt.visibility=View.VISIBLE
                    }
                    val intent = Intent(this@MainActivity, empty_activity::class.java)
                    intent.putExtra("element", player.element?.element)
                    mapa.setOnClickListener{
                        intent.putExtra("dmg", player.dmg)
                        intent.putExtra("def", player.def)
                        intent.putExtra("vel", player.vel)
                        intent.putExtra("lvl", player.lvl)
                        intent.putExtra("exp", player.exp)
                        startActivityForResult(intent,REQUEST_CODE_EXP2)
                    }
                    val intent2 = Intent(this@MainActivity, GetExp::class.java)
                    perfil.setOnClickListener{
                        intent2.putExtra("lvl", player.lvl)
                        intent2.putExtra("exp", player.exp)
                        startActivityForResult(intent2, REQUEST_CODE_EXP)
                    }
                    val intent3 = Intent(this@MainActivity, Dungeon::class.java)
                    dungeon.setOnClickListener{
                        intent3.putExtra("progress", player.progress)
                        intent3.putExtra("dmg", player.dmg)
                        intent3.putExtra("def", player.def)
                        intent3.putExtra("vel", player.vel)
                        intent3.putExtra("lvl", player.lvl)
                        intent3.putExtra("exp", player.exp)
                        startActivityForResult(intent3, REQUEST_CODE_EXP3)
                    }
                    val intent4 = Intent(this@MainActivity, Sect::class.java)
                    sect.setOnClickListener{
                        intent4.putExtra("progress", player.progress)
                        intent4.putExtra("dmg", player.dmg)
                        intent4.putExtra("def", player.def)
                        intent4.putExtra("vel", player.vel)
                        intent4.putExtra("lvl", player.lvl)
                        intent4.putExtra("exp", player.exp)
                        startActivityForResult(intent4, REQUEST_CODE_EXP4)
                    }

                }

            }
        }
        progresslvl.max=player.lvl*player.lvl*10
        progresslvl.setProgress(player.exp)
        runnable.run()
        imageFire.setOnClickListener{
            element=0
            exists=1
            editor.putInt("element", element)
            editor.putInt("exists", exists)
            editor.apply()
            runnable.run()
        }
        imageWatter.setOnClickListener{
            element=1
            exists=1
            editor.putInt("element", element)
            editor.putInt("exists", exists)
            editor.apply()
            runnable.run()
        }
        imagePlant.setOnClickListener{
            element=2
            exists=1
            editor.putInt("element", element)
            editor.putInt("exists", exists)
            editor.apply()
            runnable.run()
        }
        imageEarth.setOnClickListener{
            element=3
            exists=1
            editor.putInt("element", element)
            editor.putInt("exists", exists)
            editor.apply()
            runnable.run()
        }
        imageThunder.setOnClickListener{
            element=4
            exists=1
            editor.putInt("element", element)
            editor.putInt("exists", exists)
            editor.apply()
            runnable.run()
        }
        imageIce.setOnClickListener{
            element=5
            exists=1
            editor.putInt("element", element)
            editor.putInt("exists", exists)
            editor.apply()
            runnable.run()
        }
        back.setOnClickListener{
            fondo2.visibility=View.VISIBLE
            layoutjoc.visibility=View.VISIBLE
            fondo3.visibility=View.GONE
            layoutperfil.visibility=View.GONE
            back.visibility=View.GONE
            backtxt.visibility=View.GONE
        }
        edituser.setOnClickListener{
            user1.visibility=View.VISIBLE
            user2.visibility=View.VISIBLE
            layoutperfil.visibility=View.GONE
            back.visibility=View.GONE
            backtxt.visibility=View.GONE
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EXP) {
            val pref = getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
            val editor = pref.edit()
            if (data != null) {
                val lvl = data.getIntExtra("lvl", 1)
                val exp = data.getIntExtra("exp", 0)
                val extradmg = data.getIntExtra("dmg", 0)
                val extradef = data.getIntExtra("def", 0)
                val extravel = data.getIntExtra("vel", 0)
                player.lvl = lvl
                player.exp = exp
                editor.putInt("lvl", player.lvl)
                editor.putInt("exp", player.exp)
                player.dmg += extradmg
                player.def += extradef
                player.vel += extravel
                editor.putInt("dmg", player.dmg)
                editor.putInt("def", player.def)
                editor.putInt("vel", player.vel)
                editor.apply()
                val nivelx = findViewById<TextView>(R.id.nivelx)
                val progresslvl = findViewById<ProgressBar>(R.id.simpleProgressBar)
                val user = findViewById<TextView>(R.id.player)
                val atktext = findViewById<TextView>(R.id.atk)
                val deftxt = findViewById<TextView>(R.id.def)
                val veltxt = findViewById<TextView>(R.id.spd)
                val lvlperfil = findViewById<TextView>(R.id.lvlperfil)
                val expperfil = findViewById<TextView>(R.id.expperfil)

                user.setText(player.name)
                progresslvl.max = player.lvl * player.lvl * 10
                progresslvl.setProgress(player.exp)
                lvlperfil.setText("Nivel " + player.lvl.toString())
                expperfil.setText("Exp " + player.exp.toString())
                user.setText(player.name)
                atktext.setText("ATK = " + player.dmg.toString())
                deftxt.setText("DEF = " + player.def.toString())
                veltxt.setText("SPD = " + player.vel.toString())
                nivelx.setText("Nivel " + player.lvl.toString())
            }
        } else if (requestCode == REQUEST_CODE_EXP2) {
            val pref = getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
            val editor = pref.edit()
            if (data != null) {
                val extradmg = data.getIntExtra("dmg", 0)
                val extradef = data.getIntExtra("def", 0)
                val extravel = data.getIntExtra("vel", 0)
                player.dmg += extradmg
                player.def += extradef
                player.vel += extravel
                editor.putInt("dmg", player.dmg)
                editor.putInt("def", player.def)
                editor.putInt("vel", player.vel)
                editor.apply()
                val atktext = findViewById<TextView>(R.id.atk)
                val deftxt = findViewById<TextView>(R.id.def)
                val veltxt = findViewById<TextView>(R.id.spd)
                atktext.setText("ATK = " + player.dmg.toString())
                deftxt.setText("DEF = " + player.def.toString())
                veltxt.setText("SPD = " + player.vel.toString())
            }
        }
        else if (requestCode == REQUEST_CODE_EXP3) {
            val pref = getSharedPreferences("llave_principal", Context.MODE_PRIVATE)
            val editor = pref.edit()
            if (data != null) {
                val extradmg = data.getIntExtra("dmg", 0)
                val extradef = data.getIntExtra("def", 0)
                val extravel = data.getIntExtra("vel", 0)
                val progress = data.getIntExtra("progress", 0)
                player.dmg += extradmg
                player.def += extradef
                player.vel += extravel
                player.progress = progress
                editor.putInt("dmg", player.dmg)
                editor.putInt("def", player.def)
                editor.putInt("vel", player.vel)
                editor.putInt("progress", player.progress)
                Log.d("PROGRES",player.progress.toString())
                editor.apply()
                val atktext = findViewById<TextView>(R.id.atk)
                val deftxt = findViewById<TextView>(R.id.def)
                val veltxt = findViewById<TextView>(R.id.spd)
                atktext.setText("ATK = " + player.dmg.toString())
                deftxt.setText("DEF = " + player.def.toString())
                veltxt.setText("SPD = " + player.vel.toString())
            }
        }
    }
    fun init_player(element:Int,exp :Int,dmg:Int,def:Int,lvl:Int,vel:Int,progress:Int,name:String) : Player{
        var elementt = Element.FIRE
        if (element==1){ elementt= Element.WATER}
        else if (element==2){ elementt= Element.PLANT}
        else if (element==3){ elementt= Element.EARTH}
        else if (element==4){ elementt= Element.THUNDER}
        else if (element==5){ elementt= Element.ICE}
        val hp = 5*def
        val skills = 3
        val spirit: Spirit? = null
        return Player(elementt, lvl, hp, dmg, vel, def, exp, skills, progress,name, spirit)
    }
}
