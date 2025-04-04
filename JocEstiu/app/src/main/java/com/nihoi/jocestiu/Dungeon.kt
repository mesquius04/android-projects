package com.nihoi.jocestiu
import android.app.Activity
import android.content.Intent
import android.media.Image
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
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import com.nihoi.jocestiu.structures.Player
import com.nihoi.jocestiu.structures.Element
import com.nihoi.jocestiu.structures.Skill
import com.nihoi.jocestiu.structures.Spirit

class Dungeon : AppCompatActivity() {
    var progres=0
    var extradmg=0
    var extradef=0
    var extravel=0
    var type=0
    var ele=Element.WATER
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dungeon)

        var user=findViewById<ImageView>(R.id.user)
        val batalla=findViewById<LinearLayout>(R.id.batalla)

        var lvl=intent.getIntExtra("lvl",1)
        var dmg=intent.getIntExtra("dmg",1)
        var def=intent.getIntExtra("def",1)
        var vel=intent.getIntExtra("vel",1)
        var exp=intent.getIntExtra("exp",1)
        var name=intent.getStringExtra("name")
        var element=intent.getIntExtra("element",1)
        progres=intent.getIntExtra("progress",0)
        var player=Player(Element.FIRE, lvl, 5*def, dmg, vel, def, exp, 3,progres, name.toString(), null)
        if (element==Element.WATER.element){
            player.element=Element.WATER
            user.setBackgroundResource(R.drawable.elemental_gemstone_water)
        }
        else if (element==Element.PLANT.element){
            player.element=Element.PLANT
            user.setBackgroundResource(R.drawable.earth_leaf_imp)
        }
        else if (element==Element.EARTH.element){
            player.element=Element.EARTH
            user.setBackgroundResource(R.drawable.earth_wisp)
        }
        else if (element==Element.THUNDER.element){
            player.element=Element.THUNDER
            user.setBackgroundResource(R.drawable.arcane_orb_thunder)
        }
        else if (element==Element.ICE.element){
            player.element=Element.ICE
            user.setBackgroundResource(R.drawable.ice_whisp)
        }

        val lvl1=findViewById<Button>(R.id.lvl1)
        val lvl2=findViewById<Button>(R.id.lvl2)
        val lvl3=findViewById<Button>(R.id.lvl3)
        val lvl4=findViewById<Button>(R.id.lvl4)
        val lvl5=findViewById<Button>(R.id.lvl5)
        val lvl6=findViewById<Button>(R.id.lvl6)
        val lvl7=findViewById<Button>(R.id.lvl7)
        val lvl8=findViewById<Button>(R.id.lvl8)
        val lvl9=findViewById<Button>(R.id.lvl9)
        val lvl10=findViewById<Button>(R.id.lvl10)
        val lvl11=findViewById<Button>(R.id.lvl11)
        val lvl12=findViewById<Button>(R.id.lvl12)
        val lvl13=findViewById<Button>(R.id.lvl13)
        val lvl14=findViewById<Button>(R.id.lvl14)
        val lvl15=findViewById<Button>(R.id.lvl15)
        val lvl16=findViewById<Button>(R.id.lvl16)
        val lvl17=findViewById<Button>(R.id.lvl17)
        val lvl18=findViewById<Button>(R.id.lvl18)
        val lvl19=findViewById<Button>(R.id.lvl19)
        val lvl20=findViewById<Button>(R.id.lvl20)
        val lvl21=findViewById<Button>(R.id.lvl21)
        val lvl22=findViewById<Button>(R.id.lvl22)
        val lvl23=findViewById<Button>(R.id.lvl23)
        val lvl24=findViewById<Button>(R.id.lvl24)
        val lvl25=findViewById<Button>(R.id.lvl25)
        val lvl26=findViewById<Button>(R.id.lvl26)
        val lvl27=findViewById<Button>(R.id.lvl27)
        val lvl28=findViewById<Button>(R.id.lvl28)
        val lvl29=findViewById<Button>(R.id.lvl29)
        val lvl30=findViewById<Button>(R.id.lvl30)

        if (progres>=25){
            lvl21.setBackgroundResource(R.color.done)
            lvl22.setBackgroundResource(R.color.done)
            lvl23.setBackgroundResource(R.color.done)
            lvl24.setBackgroundResource(R.color.done)
            lvl25.setBackgroundResource(R.color.done)
        }
        if (progres>=20){
            lvl16.setBackgroundResource(R.color.done)
            lvl17.setBackgroundResource(R.color.done)
            lvl18.setBackgroundResource(R.color.done)
            lvl19.setBackgroundResource(R.color.done)
            lvl20.setBackgroundResource(R.color.done)
        }
        if (progres>=15){
            lvl11.setBackgroundResource(R.color.done)
            lvl12.setBackgroundResource(R.color.done)
            lvl13.setBackgroundResource(R.color.done)
            lvl14.setBackgroundResource(R.color.done)
            lvl15.setBackgroundResource(R.color.done)
        }
        if (progres>=10){
            lvl6.setBackgroundResource(R.color.done)
            lvl7.setBackgroundResource(R.color.done)
            lvl8.setBackgroundResource(R.color.done)
            lvl9.setBackgroundResource(R.color.done)
            lvl10.setBackgroundResource(R.color.done)
        }
        if (progres>=5){
            lvl1.setBackgroundResource(R.color.done)
            lvl2.setBackgroundResource(R.color.done)
            lvl3.setBackgroundResource(R.color.done)
            lvl4.setBackgroundResource(R.color.done)
            lvl5.setBackgroundResource(R.color.done)
        }


        lvl1.setOnClickListener {
            startbatle(1,player)
        }
        lvl2.setOnClickListener {
            startbatle(2,player)
        }
        lvl3.setOnClickListener {
            startbatle(3,player)
        }
        lvl4.setOnClickListener {
            startbatle(4,player)
        }
        lvl5.setOnClickListener {
            startbatle(5,player)
        }
        lvl6.setOnClickListener {
            startbatle(6,player)
        }
        lvl7.setOnClickListener {
            startbatle(7,player)
        }
        lvl8.setOnClickListener {
            startbatle(8,player)
        }
        lvl9.setOnClickListener {
            startbatle(9,player)
        }
        lvl10.setOnClickListener {
            startbatle(10,player)
        }
        lvl11.setOnClickListener {
            startbatle(11,player)
        }
        lvl12.setOnClickListener {
            startbatle(12,player)
        }
        lvl13.setOnClickListener {
            startbatle(13,player)
        }
        lvl14.setOnClickListener {
            startbatle(14,player)
        }
        lvl15.setOnClickListener {
            startbatle(15,player)
        }
        lvl16.setOnClickListener {
            startbatle(16,player)
        }
        lvl17.setOnClickListener {
            startbatle(17,player)
        }
        lvl18.setOnClickListener {
            startbatle(18,player)
        }
        lvl19.setOnClickListener {
            startbatle(19,player)
        }
        lvl20.setOnClickListener {
            startbatle(20,player)
        }
        lvl21.setOnClickListener {
            startbatle(21,player)
        }
        lvl22.setOnClickListener {
            startbatle(22,player)
        }
        lvl23.setOnClickListener {
            startbatle(23,player)
        }
        lvl24.setOnClickListener {
            startbatle(24,player)
        }
        lvl25.setOnClickListener {
            startbatle(25,player)
        }
        lvl26.setOnClickListener {
            startbatle(26,player)
        }
        lvl27.setOnClickListener {
            startbatle(27,player)
        }
        lvl28.setOnClickListener {
            startbatle(28,player)
        }
        lvl29.setOnClickListener {
            startbatle(29,player)
        }
        lvl30.setOnClickListener {
            startbatle(30,player)
        }
        val fulla=findViewById<ImageButton>(R.id.resum)
        val victory=findViewById<LinearLayout>(R.id.victory)
        val waifu=findViewById<ImageView>(R.id.waifu)
        val fondomenu=findViewById<ImageView>(R.id.menudungeonfondo)
        val fondobatalla=findViewById<ImageView>(R.id.batallafondo)
        val batle=findViewById<LinearLayout>(R.id.batalla)
        val nivells=findViewById<LinearLayout>(R.id.menulvl)
        fulla.setOnClickListener {
            fulla.visibility=View.GONE
            waifu.visibility=View.GONE
            victory.visibility=View.GONE
            fondomenu.visibility= View.VISIBLE
            nivells.visibility=View.VISIBLE
        }
    }
    fun startbatle(lvl:Int,player:Player){
        if (lvl-1<=progres){
            var enemy= structures.Player(
                Element.FIRE,
                5 * lvl*lvl,
                5 * lvl * lvl*lvl,
                5 * lvl*lvl,
                5 * lvl*lvl,
                5 * lvl*lvl,
                0,
                3,
                0,
                "GUARDIAN",
                null
            )
            start_battle(player,enemy,lvl)
        }
    }
    fun start_battle(player:Player,enemy1:Player,lvl : Int){
        var j=1

        val atk1=findViewById<Button>(R.id.atk1)
        val atk2=findViewById<Button>(R.id.atk2)
        val atk3=findViewById<Button>(R.id.atk3)
        val atk4=findViewById<Button>(R.id.atk4)
        val e1nemy=findViewById<ImageView>(R.id.enemy1)
        var userhp=findViewById<ProgressBar>(R.id.simpleProgressBar)
        var enemyhp=findViewById<ProgressBar>(R.id.simpleProgressBar2)
        userhp.max=player.def*5
        userhp.progress = player.hp
        enemyhp.max=enemy1.def*5
        enemyhp.progress = enemy1.hp
        if (lvl<=5){
            e1nemy.setBackgroundResource(R.drawable.darkness_banshee)}
        else if (lvl<=10){
            e1nemy.setBackgroundResource(R.drawable.darkness_angel_reaper)
        }
        else if (lvl<=15){
            e1nemy.setBackgroundResource(R.drawable.darkness_behemoth)
        }
        else if (lvl<=20){
            e1nemy.setBackgroundResource(R.drawable.darkness_blade_colossus)
        }
        else if (lvl<=25){
            e1nemy.setBackgroundResource(R.drawable.darkness_cultist_mage)
        }
        else if (lvl<=30){
            e1nemy.setBackgroundResource(R.drawable.darkness_blade_reaper)
        }
        val fondomenu=findViewById<ImageView>(R.id.menudungeonfondo)
        val fondobatalla=findViewById<ImageView>(R.id.batallafondo)
        val batle=findViewById<LinearLayout>(R.id.batalla)
        val nivells=findViewById<LinearLayout>(R.id.menulvl)
        fondomenu.visibility=View.GONE
        fondobatalla.visibility=View.VISIBLE
        batle.visibility=View.VISIBLE
        nivells.visibility=View.GONE
        enemyhp.max=enemy1.def*5
        userhp.max=player.def*5
        enemy1.hp=enemy1.def*5
        player.hp=player.def*5
        enemyhp.progress=enemy1.hp
        userhp.progress=player.hp
        Log.d("DEF",player.hp.toString())
        Log.d("DEF",enemy1.hp.toString())
        if (enemy1.hp>0 && player.hp>0){
            Log.d("PROVA","LALALALALALAL")
            user_turn(player,enemy1,lvl)
        }
    }
    fun user_turn(player:Player,enemy1:Player,diff:Int){
        val atk1=findViewById<Button>(R.id.atk1)
        val atk2=findViewById<Button>(R.id.atk2)
        val atk3=findViewById<Button>(R.id.atk3)
        val atk4=findViewById<Button>(R.id.atk4)
        val e1nemy=findViewById<ImageView>(R.id.enemy1)
        var userhp=findViewById<ProgressBar>(R.id.simpleProgressBar)
        var enemyhp=findViewById<ProgressBar>(R.id.simpleProgressBar2)
        atk1.setOnClickListener {
            if (enemy1.hp>0){
                enemy1.hp-=player.dmg
                enemyhp.progress = enemy1.hp
                if(enemy1.hp<=0){
                    val batalla=findViewById<LinearLayout>(R.id.batalla)
                    val waifu=findViewById<ImageView>(R.id.waifu)
                    waifu.visibility=View.VISIBLE
                    val victoria=findViewById<TextView>(R.id.victoria)
                    victoria.setText("VICTORIA")
                    val random = Random()
                    if (progres==diff-1){
                        progres++
                        extradmg+=random.nextInt(5)+diff
                        extradef+=random.nextInt(5)+diff
                        extravel+=random.nextInt(5)+diff
                    }
                    extradmg+=random.nextInt(2)
                    extradef+=random.nextInt(2)
                    extravel+=random.nextInt(2)
                    player.hp=player.def*5
                    enemy1.hp=enemy1.def*5
                    val extrastats=findViewById<TextView>(R.id.extrastats)
                    extrastats.visibility=View.VISIBLE
                    victoria.visibility=View.VISIBLE
                    waifu.visibility=View.VISIBLE
                    extrastats.setText("+"+extradmg.toString()+" ATK   +"+extradef.toString()+" DEF\n   +"+extravel.toString()+" VEL   ")

                    e1nemy.visibility=View.VISIBLE
                    batalla.visibility=View.GONE
                    val fulla=findViewById<ImageButton>(R.id.resum)
                    val victory=findViewById<LinearLayout>(R.id.victory)
                    fulla.visibility=View.VISIBLE
                    victory.visibility=View.VISIBLE
                }
                enemy_turn(player,enemy1,diff)
            }
        }
        atk2.setOnClickListener {
            var random=Random()
            var crit=random.nextInt(100)+1
            if (enemy1.hp>0){
                if(crit>=25){
                    enemy1.hp-=player.dmg
                    enemyhp.progress = enemy1.hp
                }
                else if(crit>=10){
                }
                else{
                    enemy1.hp-=(player.dmg*1.5).toInt()
                    enemyhp.progress = enemy1.hp
                }

                if(enemy1.hp<=0){
                    val batalla=findViewById<LinearLayout>(R.id.batalla)
                    val waifu=findViewById<ImageView>(R.id.waifu)
                    waifu.visibility=View.VISIBLE
                    val victoria=findViewById<TextView>(R.id.victoria)
                    victoria.setText("VICTORIA")
                    val random = Random()
                    if (progres==diff-1){
                        progres++
                        extradmg+=random.nextInt(5)+diff
                        extradef+=random.nextInt(5)+diff
                        extravel+=random.nextInt(5)+diff
                    }
                    extradmg+=random.nextInt(2)
                    extradef+=random.nextInt(2)
                    extravel+=random.nextInt(2)
                    player.hp=player.def*5
                    enemy1.hp=enemy1.def*5
                    val extrastats=findViewById<TextView>(R.id.extrastats)
                    extrastats.visibility=View.VISIBLE
                    victoria.visibility=View.VISIBLE
                    waifu.visibility=View.VISIBLE
                    extrastats.setText("+"+extradmg.toString()+" ATK   +"+extradef.toString()+" DEF\n   +"+extravel.toString()+" VEL   ")

                    e1nemy.visibility=View.VISIBLE
                    batalla.visibility=View.GONE
                    val fulla=findViewById<ImageButton>(R.id.resum)
                    val victory=findViewById<LinearLayout>(R.id.victory)
                    fulla.visibility=View.VISIBLE
                    victory.visibility=View.VISIBLE
                }
                enemy_turn(player,enemy1,diff)
            }
        }
        atk3.setOnClickListener {
            if (player.hp>0){
                if ((player.hp+player.dmg*1.3).toInt()<=player.def*5){
                    player.hp+=(player.dmg*1.3).toInt()
                }
                else {
                    player.hp=player.def*5
                }
                userhp.progress = player.hp
                enemy_turn(player,enemy1,diff)
            }
        }
        atk4.setOnClickListener {
            val batalla=findViewById<LinearLayout>(R.id.batalla)
            val fulla=findViewById<ImageButton>(R.id.resum)
            val victory=findViewById<LinearLayout>(R.id.victory)
            val victoria=findViewById<TextView>(R.id.victoria)
            val extrastats=findViewById<TextView>(R.id.extrastats)
            victoria.setText("DERROTA")
            player.hp=player.def*5
            enemy1.hp=enemy1.def*5
            e1nemy.visibility=View.VISIBLE
            extrastats.visibility=View.GONE
            batalla.visibility=View.GONE
            victoria.visibility=View.VISIBLE
            victory.visibility=View.VISIBLE
            val waifu=findViewById<ImageView>(R.id.waifu)
            waifu.visibility=View.VISIBLE
            fulla.visibility=View.VISIBLE
        }
    }
    fun enemy_turn(player:Player,enemy1:Player,diff:Int){
        val atk1=findViewById<Button>(R.id.atk1)
        val atk2=findViewById<Button>(R.id.atk2)
        val atk3=findViewById<Button>(R.id.atk3)
        val atk4=findViewById<Button>(R.id.atk4)
        val e1nemy=findViewById<ImageView>(R.id.enemy1)
        var userhp=findViewById<ProgressBar>(R.id.simpleProgressBar)
        var enemyhp=findViewById<ProgressBar>(R.id.simpleProgressBar2)
        if (enemy1.hp>0){
            player.hp-=enemy1.dmg
            userhp.progress = player.hp
            enemyhp.max=enemy1.def*5
            enemyhp.progress=enemy1.hp
            enemyhp.visibility=View.GONE
            enemyhp.visibility=View.VISIBLE
            userhp.visibility=View.GONE
            userhp.visibility=View.VISIBLE
            Thread.sleep(150)
            if(player.hp<=0){
                val menuagua=findViewById<ScrollView>(R.id.menuagua)
                val fondomenuagua=findViewById<ImageView>(R.id.fondomenuagua)
                val fondobatallaagua=findViewById<ImageView>(R.id.fondobatallaagua)
                val batalla=findViewById<LinearLayout>(R.id.batalla)
                val fulla=findViewById<ImageButton>(R.id.resum)
                val victory=findViewById<LinearLayout>(R.id.victory)
                val victoria=findViewById<TextView>(R.id.victoria)
                val extrastats=findViewById<TextView>(R.id.extrastats)
                victory.visibility=View.VISIBLE
                victoria.setText("DERROTA")
                player.hp=player.def*5
                enemy1.hp=enemy1.def*5
                extrastats.visibility=View.GONE
                e1nemy.visibility=View.VISIBLE
                batalla.visibility=View.GONE
                victoria.visibility=View.VISIBLE
                val waifu=findViewById<ImageView>(R.id.waifu)
                waifu.visibility=View.VISIBLE
                fulla.visibility=View.VISIBLE
                return
            }
            else{
                user_turn(player,enemy1,diff)
            }

        }
    }
    override fun onBackPressed() {
        val intent = Intent(this@Dungeon, MainActivity::class.java)
        intent.putExtra("dmg", extradmg)
        intent.putExtra("def", extradef)
        intent.putExtra("vel",extravel)
        intent.putExtra("progress",progres)
        setResult(Activity.RESULT_OK, intent)
        super.onBackPressed()
        finish()
    }
}