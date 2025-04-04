package com.nihoi.jocestiu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
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
import org.w3c.dom.Text
import java.util.Random

class empty_activity : AppCompatActivity() {
    var extradmg=0
    var extradef=0
    var extravel=0
    var type=0
    var ele=Element.WATER
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
        supportActionBar?.setTitle(R.string.actionbar_title)
        setTheme(R.style.AppTheme)

        var lvl=intent.getIntExtra("lvl",1)
        var dmg=intent.getIntExtra("dmg",1)
        var def=intent.getIntExtra("def",1)
        var vel=intent.getIntExtra("vel",1)
        var exp=intent.getIntExtra("exp",1)
        var name=intent.getStringExtra("name")
        var element=intent.getIntExtra("element",1)
        var diff=1

        val fondoprev=findViewById<ImageView>(R.id.fondoprev)
        val menuprev=findViewById<LinearLayout>(R.id.prevdungeons)
        val waterdungeon=findViewById<ImageButton>(R.id.waterdungeon)
        val firedungeon=findViewById<ImageButton>(R.id.firedungeon)
        val plantdungeon=findViewById<ImageButton>(R.id.plantdungeon)
        val earthdungeon=findViewById<ImageButton>(R.id.earthdungeon)
        val thunderdungeon=findViewById<ImageButton>(R.id.thunderdungeon)
        val icedungeon=findViewById<ImageButton>(R.id.icedungeon)

        val round=findViewById<TextView>(R.id.ronda)
        var user=findViewById<ImageView>(R.id.user)
        val fondomenuagua=findViewById<ImageView>(R.id.fondomenuagua)
        val fondobatallaagua=findViewById<ImageView>(R.id.fondobatallaagua)
        val batalla=findViewById<LinearLayout>(R.id.batalla)
        val dungeon1=findViewById<Button>(R.id.dungeon1)
        val dungeon2=findViewById<Button>(R.id.dungeon2)
        val dungeon3=findViewById<Button>(R.id.dungeon3)
        val dungeon4=findViewById<Button>(R.id.dungeon4)
        val dungeon5=findViewById<Button>(R.id.dungeon5)
        val dungeon6=findViewById<Button>(R.id.dungeon6)
        val dungeon7=findViewById<Button>(R.id.dungeon7)
        val dungeon8=findViewById<Button>(R.id.dungeon8)

        val e1nemy=findViewById<ImageView>(R.id.enemy1)

        val menuagua=findViewById<ScrollView>(R.id.menuagua)
        var player=Player(Element.FIRE, lvl, 5*def, dmg, vel, def, exp, 3,0, name.toString(), null)
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
        waterdungeon.setOnClickListener{
            type=0
            ele=Element.WATER
            fondobatallaagua.setBackgroundResource(R.drawable.reflecting_pool)
            fondoprev.visibility=View.GONE
            menuprev.visibility=View.GONE
            menuagua.visibility= View.VISIBLE
            fondomenuagua.visibility=View.VISIBLE
            dungeon1.setText("1. Rio de las carpas")
            dungeon2.setText("2. Costa Celeste")
            dungeon3.setText("3. Barrera Coralina")
            dungeon4.setText("4. Fosa de los cadaveres")
            dungeon5.setText("5. Ruinas del arca")
            dungeon6.setText("6. Cadaver del KRAKEN PRIMORDIAL")
            dungeon7.setText("7. Guarida del KRAKEN DESPIADADO")
            dungeon8.setText("8. Trono del KRAKEN DESPIADADO")
        }
        firedungeon.setOnClickListener{
            fondoprev.visibility=View.GONE
            ele=Element.FIRE
            menuprev.visibility=View.GONE
            type=1
            fondobatallaagua.setBackgroundResource(R.drawable.fire_themed_castles_10)
            menuagua.visibility= View.VISIBLE
            fondomenuagua.visibility=View.VISIBLE
            dungeon1.setText("1. Llanera infernal")
            dungeon2.setText("2. Camino volcanico")
            dungeon3.setText("3. Ruinas del antiguo templo")
            dungeon4.setText("4. Piscina de lava")
            dungeon5.setText("5. Estalactitas de magma")
            dungeon6.setText("6. Cadaver del antiguo REY DRAGON")
            dungeon7.setText("7. Tesoro del DRAGON INFERNAL")
            dungeon8.setText("8. Trono del DRAGON INFERNAL")
        }
        plantdungeon.setOnClickListener{
            fondoprev.visibility=View.GONE
            ele=Element.PLANT
            menuprev.visibility=View.GONE
            type=2
            fondobatallaagua.setBackgroundResource(R.drawable.fire_themed_castles_10)
            menuagua.visibility= View.VISIBLE
            fondomenuagua.visibility=View.VISIBLE
            dungeon1.setText("1. Jardin Floral")
            dungeon2.setText("2. Valle de las Rosas")
            dungeon3.setText("3. Arbol espititual")
            dungeon4.setText("4. Enredaderas Magicas")
            dungeon5.setText("5. Hierbas elficas")
            dungeon6.setText("6. Brote del ARBOL PRIMOGENEO")
            dungeon7.setText("7. Raiz del ARBOL DEL MUNDO")
            dungeon8.setText("8. Copa del ARBOL DEL MUNDO")
        }
        earthdungeon.setOnClickListener{
            fondoprev.visibility=View.GONE
            ele=Element.EARTH
            menuprev.visibility=View.GONE
            type=3
            fondobatallaagua.setBackgroundResource(R.drawable.hallway_3)
            menuagua.visibility= View.VISIBLE
            fondomenuagua.visibility=View.VISIBLE
            dungeon1.setText("1. Desierto Infinito")
            dungeon2.setText("2. Rocas Antiguas")
            dungeon3.setText("3. Arenas movedizas")
            dungeon4.setText("4. Epicentro del Mundo")
            dungeon5.setText("5. Antiguas Rocas Runicas")
            dungeon6.setText("6. Restos del PRIMER GOLEM")
            dungeon7.setText("7. Portal del GOLEM RUNICO")
            dungeon8.setText("8. Trono del GOLEM RUNICO")
        }
        thunderdungeon.setOnClickListener{
            fondoprev.visibility=View.GONE
            ele=Element.THUNDER
            menuprev.visibility=View.GONE
            type=4
            fondobatallaagua.setBackgroundResource(R.drawable.fire_themed_castles_10)
            menuagua.visibility= View.VISIBLE
            fondomenuagua.visibility=View.VISIBLE
            dungeon1.setText("1. Valle Relampago")
            dungeon2.setText("2. Montaña Electrica")
            dungeon3.setText("3. Campo Electrico")
            dungeon4.setText("4. Zona Electrostatica")
            dungeon5.setText("5. Cuspide del Trueno")
            dungeon6.setText("6. Antiguo LEON DE LOS 9 RAYOS")
            dungeon7.setText("7. Salon del LEON DEL RAYO")
            dungeon8.setText("8. Trono del LEON DEL RAYO")
        }
        icedungeon.setOnClickListener{
            fondoprev.visibility=View.GONE
            ele=Element.ICE
            menuprev.visibility=View.GONE
            type=5
            fondobatallaagua.setBackgroundResource(R.drawable.fire_themed_castles_10)
            menuagua.visibility= View.VISIBLE
            fondomenuagua.visibility=View.VISIBLE
            dungeon1.setText("1. Arbol conjelado")
            dungeon2.setText("2. Valle nevado")
            dungeon3.setText("3. Nieve de sangre")
            dungeon4.setText("4. Hielo Inamobile")
            dungeon5.setText("5. Iglu rosado")
            dungeon6.setText("6. Antiguo TITAN DE HIELO")
            dungeon7.setText("7. Salon del TITAN DE HIELO")
            dungeon8.setText("8. Trono del TITAN DE HIELO")
        }
        var enemy1=Player(Element.WATER, 5*diff, 5*(lvl*lvl*(1.8)).toInt(), (lvl*lvl*(1.7)).toInt(), (lvl*lvl*(1.6)).toInt(), (lvl*lvl*(1.8)).toInt(), 0, 3, 0,"SEQUAZ", null)
        var enemy2=Player(Element.WATER,5*diff,5*(lvl*lvl*(2.4)).toInt(),(lvl*lvl*(2.2)).toInt(), (lvl*lvl*(2)).toInt(),(lvl*lvl*(1.6)).toInt(), (lvl*lvl*(2.4)).toInt(),0,  3, "SEQUAZ", null)
        var strongenemy=5*diff
        dungeon1.setOnClickListener {
            diff=1
            strongenemy=5*diff
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3,0, "SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3,0, "KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        dungeon2.setOnClickListener {
            diff=2
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE
            strongenemy=5*diff

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3, 0,"SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3, 0,"KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        dungeon3.setOnClickListener {
            diff=3
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE
            strongenemy=5*diff

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3,0, "SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3,0, "KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        dungeon4.setOnClickListener {
            diff=4
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE
            strongenemy=5*diff

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3,0, "SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3,0, "KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        dungeon5.setOnClickListener {
            diff=5
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE
            strongenemy=5*diff

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3,0, "SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3,0, "KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        dungeon6.setOnClickListener {
            diff=6
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE
            strongenemy=5*diff

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3,0, "SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3,0, "KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        dungeon7.setOnClickListener {
            diff=7
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE
            strongenemy=5*diff

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3,0, "SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3,0, "KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        dungeon8.setOnClickListener {
            diff=8
            menuagua.visibility= View.GONE
            fondomenuagua.visibility=View.GONE
            fondobatallaagua.visibility=View.VISIBLE
            batalla.visibility=View.VISIBLE
            round.visibility=View.VISIBLE
            strongenemy=5*diff

            enemy1=Player(ele, 5*diff, 5*(strongenemy*strongenemy*(0.5)).toInt(), (strongenemy*strongenemy*(0.45)).toInt(), (strongenemy*strongenemy*(0.4)).toInt(), (strongenemy*strongenemy*(0.5)).toInt(), 0, 3,0, "SEQUAZ", null)
            enemy2=Player(ele,5*diff,5*(strongenemy*strongenemy*(1)).toInt(),(strongenemy*strongenemy*(0.9)).toInt(), (strongenemy*strongenemy*(0.8)).toInt(),(strongenemy*strongenemy*(1)).toInt(), (strongenemy*strongenemy*(2.4)).toInt(),  3,0, "KRAKEN", null)
            start_battle(player,enemy1,enemy2,diff)
        }
        val fulla=findViewById<ImageButton>(R.id.resum)
        val victory=findViewById<LinearLayout>(R.id.victory)
        val waifu=findViewById<ImageView>(R.id.waifu)
        fulla.setOnClickListener {
            fulla.visibility=View.GONE
            waifu.visibility=View.GONE
            victory.visibility=View.GONE
            menuagua.visibility= View.VISIBLE
            fondomenuagua.visibility=View.VISIBLE
            fondobatallaagua.visibility=View.GONE
        }

    }
    fun start_battle(player:Player,enemy1:Player,enemy2:Player,diff : Int){
        var j=1

        val atk1=findViewById<Button>(R.id.atk1)
        val atk2=findViewById<Button>(R.id.atk2)
        val atk3=findViewById<Button>(R.id.atk3)
        val atk4=findViewById<Button>(R.id.atk4)
        val e1nemy=findViewById<ImageView>(R.id.enemy1)
        val e2nemy=findViewById<ImageView>(R.id.enemy2)
        var userhp=findViewById<ProgressBar>(R.id.simpleProgressBar)
        var enemyhp=findViewById<ProgressBar>(R.id.simpleProgressBar2)
        userhp.max=player.def*5
        userhp.progress = player.hp
        enemyhp.max=enemy1.def*5
        enemyhp.progress = enemy1.hp
        enemy2.hp=enemy2.def*5
            if (diff<=3){
                if (type==0){
                e1nemy.setBackgroundResource(R.drawable.slime_wateri)}
                else if (type==1){
                    e1nemy.setBackgroundResource(R.drawable.slime_firei)
                }
                else if (type==2){
                    e1nemy.setBackgroundResource(R.drawable.slime_holyi)
                }
                else if (type==3){
                    e1nemy.setBackgroundResource(R.drawable.slime_earthi)
                }
                else if (type==4){
                    e1nemy.setBackgroundResource(R.drawable.slime_thunderi)
                }
                else if (type==5){
                    e1nemy.setBackgroundResource(R.drawable.slime_icei)
                }
            }
            else if (diff<=5){
                if (type==0){
                    e1nemy.setBackgroundResource(R.drawable.slime_waterii)}
                else if (type==1){
                    e1nemy.setBackgroundResource(R.drawable.slime_fireii)
                }
                else if (type==2){
                    e1nemy.setBackgroundResource(R.drawable.slime_holyii)
                }
                else if (type==3){
                    e1nemy.setBackgroundResource(R.drawable.slime_earthii)
                }
                else if (type==4){
                    e1nemy.setBackgroundResource(R.drawable.slime_thunderii)
                }
                else if (type==5){
                    e1nemy.setBackgroundResource(R.drawable.slime_iceii)
                }

            }
            else if (diff<=8){
                if (type==0){
                    e1nemy.setBackgroundResource(R.drawable.slime_wateriii)}
                else if (type==1){
                    e1nemy.setBackgroundResource(R.drawable.slime_fireiii)
                }
                else if (type==2){
                    e1nemy.setBackgroundResource(R.drawable.slime_holyiii)
                }
                else if (type==3){
                    e1nemy.setBackgroundResource(R.drawable.slime_earthiii)
                }
                else if (type==4){
                    e1nemy.setBackgroundResource(R.drawable.slime_thunderiii)
                }
                else if (type==5){
                    e1nemy.setBackgroundResource(R.drawable.slime_iceiii)
                }
            }
            if (diff<=4){
                if (type==0){
                    e2nemy.setBackgroundResource(R.drawable.dragon_wyvern_blue)}
                else if (type==1){
                    e2nemy.setBackgroundResource(R.drawable.corrupted_void_fire_wolf)
                }
                else if (type==2){
                    e2nemy.setBackgroundResource(R.drawable.elemental_earth_spirit_tellia)
                }
                else if (type==3){
                    e2nemy.setBackgroundResource(R.drawable.titan_earth_terran)
                }
                else if (type==4){
                    e2nemy.setBackgroundResource(R.drawable.light_summoned_angel)
                }
                else if (type==5){
                    e2nemy.setBackgroundResource(R.drawable.ice_lion)
                }
            }
            else if (diff<=8) {
                if (type == 0) {
                    e2nemy.setBackgroundResource(R.drawable.dragon_king_blue)
                }
                else if (type == 1) {
                    e2nemy.setBackgroundResource(R.drawable.fire_lava_worm)
                }
                else if (type == 2) {
                    e2nemy.setBackgroundResource(R.drawable.boss_nature_titan_tellia)
                }
                else if (type == 3) {
                    e2nemy.setBackgroundResource(R.drawable.earth_gemstone_golem)
                }
                else if (type == 4) {
                    e2nemy.setBackgroundResource(R.drawable.titans_thunder_dynamo)
                }
                else if (type == 5) {
                    e2nemy.setBackgroundResource(R.drawable.boss_ice_titan_demeres)
                }
            }
        if ((enemy1.hp>0 ||enemy2.hp>0) && player.hp>0){
            user_turn(player,enemy1,enemy2,diff)
        }
    }
    fun user_turn(player:Player,enemy1:Player,enemy2:Player,diff:Int){
        val atk1=findViewById<Button>(R.id.atk1)
        val atk2=findViewById<Button>(R.id.atk2)
        val atk3=findViewById<Button>(R.id.atk3)
        val atk4=findViewById<Button>(R.id.atk4)
        val e1nemy=findViewById<ImageView>(R.id.enemy1)
        val round=findViewById<TextView>(R.id.ronda)
        val e2nemy=findViewById<ImageView>(R.id.enemy2)
        var userhp=findViewById<ProgressBar>(R.id.simpleProgressBar)
        var enemyhp=findViewById<ProgressBar>(R.id.simpleProgressBar2)
        atk1.setOnClickListener {
            if (enemy1.hp>0){
                enemy1.hp-=player.dmg
                enemyhp.progress = enemy1.hp
                if(enemy1.hp<=0){
                    e1nemy.visibility=View.GONE
                    e2nemy.visibility=View.VISIBLE
                    round.setText("RONDA 2")
                    enemyhp.max=enemy2.def*5
                    enemyhp.progress = enemy2.hp
                }
                enemy_turn(player,enemy1,enemy2,diff)
            }
            else if (enemy2.hp>=0){
                enemy2.hp-=player.dmg
                enemyhp.progress = enemy2.hp
                if(enemy2.hp<=0){
                    val menuagua=findViewById<ScrollView>(R.id.menuagua)
                    val fondomenuagua=findViewById<ImageView>(R.id.fondomenuagua)
                    val fondobatallaagua=findViewById<ImageView>(R.id.fondobatallaagua)
                    val batalla=findViewById<LinearLayout>(R.id.batalla)
                    val waifu=findViewById<ImageView>(R.id.waifu)
                    waifu.visibility=View.VISIBLE
                    val round=findViewById<TextView>(R.id.ronda)
                    val victoria=findViewById<TextView>(R.id.victoria)
                    victoria.setText("VICTORIA")
                    round.setText("RONDA 1")
                    val random = Random()
                    extradmg+=random.nextInt(2)+diff
                    extradef+=random.nextInt(2)+diff
                    extravel+=random.nextInt(2)+diff
                    player.hp=player.def*5
                    enemy1.hp=enemy1.def*5
                    enemy2.hp=enemy1.def*5
                    val extrastats=findViewById<TextView>(R.id.extrastats)
                    extrastats.visibility=View.VISIBLE
                    victoria.visibility=View.VISIBLE
                    waifu.visibility=View.VISIBLE
                    extrastats.setText("+"+extradmg.toString()+" ATK   +"+extradef.toString()+" DEF\n   +"+extravel.toString()+" VEL   ")

                    e1nemy.visibility=View.VISIBLE
                    e2nemy.visibility=View.GONE
                    batalla.visibility=View.GONE
                    round.visibility=View.GONE
                    val fulla=findViewById<ImageButton>(R.id.resum)
                    val victory=findViewById<LinearLayout>(R.id.victory)
                    fulla.visibility=View.VISIBLE
                    victory.visibility=View.VISIBLE
                }
                else{
                enemy_turn(player,enemy1,enemy2,diff)}
            }
        }
        atk4.setOnClickListener {
            val batalla=findViewById<LinearLayout>(R.id.batalla)
            val round=findViewById<TextView>(R.id.ronda)
            val fulla=findViewById<ImageButton>(R.id.resum)
            val victory=findViewById<LinearLayout>(R.id.victory)
            val victoria=findViewById<TextView>(R.id.victoria)
            val extrastats=findViewById<TextView>(R.id.extrastats)
            victoria.setText("DERROTA")
            player.hp=player.def*5
            enemy1.hp=enemy1.def*5
            enemy2.hp=enemy1.def*5
            round.setText("RONDA 1")
            e1nemy.visibility=View.VISIBLE
            extrastats.visibility=View.GONE
            e2nemy.visibility=View.GONE
            batalla.visibility=View.GONE
            round.visibility=View.GONE
            victoria.visibility=View.VISIBLE
            victory.visibility=View.VISIBLE
            val waifu=findViewById<ImageView>(R.id.waifu)
            waifu.visibility=View.VISIBLE
            fulla.visibility=View.VISIBLE
        }
    }
    fun enemy_turn(player:Player,enemy1:Player,enemy2:Player,diff:Int){
        val atk1=findViewById<Button>(R.id.atk1)
        val atk2=findViewById<Button>(R.id.atk2)
        val round=findViewById<TextView>(R.id.ronda)
        val atk3=findViewById<Button>(R.id.atk3)
        val atk4=findViewById<Button>(R.id.atk4)
        val e1nemy=findViewById<ImageView>(R.id.enemy1)
        val e2nemy=findViewById<ImageView>(R.id.enemy2)
        var userhp=findViewById<ProgressBar>(R.id.simpleProgressBar)
        var enemyhp=findViewById<ProgressBar>(R.id.simpleProgressBar2)
        if (enemy1.hp>0){
            player.hp-=enemy1.dmg
            userhp.progress = player.hp
            userhp.visibility=View.GONE
            userhp.visibility=View.VISIBLE
            Thread.sleep(150)
            if(player.hp<=0){
                val menuagua=findViewById<ScrollView>(R.id.menuagua)
                val fondomenuagua=findViewById<ImageView>(R.id.fondomenuagua)
                val fondobatallaagua=findViewById<ImageView>(R.id.fondobatallaagua)
                val batalla=findViewById<LinearLayout>(R.id.batalla)
                val round=findViewById<TextView>(R.id.ronda)
                val fulla=findViewById<ImageButton>(R.id.resum)
                val victory=findViewById<LinearLayout>(R.id.victory)
                val victoria=findViewById<TextView>(R.id.victoria)
                val extrastats=findViewById<TextView>(R.id.extrastats)
                victory.visibility=View.VISIBLE
                victoria.setText("DERROTA")
                player.hp=player.def*5
                enemy1.hp=enemy1.def*5
                enemy2.hp=enemy1.def*5
                extrastats.visibility=View.GONE
                round.setText("RONDA 1")
                e1nemy.visibility=View.VISIBLE
                e2nemy.visibility=View.GONE
                batalla.visibility=View.GONE
                round.visibility=View.GONE
                victoria.visibility=View.VISIBLE
                val waifu=findViewById<ImageView>(R.id.waifu)
                waifu.visibility=View.VISIBLE
                fulla.visibility=View.VISIBLE
                return
            }
            else{
                user_turn(player,enemy1,enemy2,diff)
            }

        }
        else if (enemy2.hp>0){
            player.hp-=enemy2.dmg
            Thread.sleep(150)
            userhp.progress = player.hp
            userhp.visibility=View.GONE
            userhp.visibility=View.VISIBLE

            if(player.hp<=0){
                val menuagua=findViewById<ScrollView>(R.id.menuagua)
                val fondomenuagua=findViewById<ImageView>(R.id.fondomenuagua)
                val fondobatallaagua=findViewById<ImageView>(R.id.fondobatallaagua)
                val batalla=findViewById<LinearLayout>(R.id.batalla)
                val round=findViewById<TextView>(R.id.ronda)
                val fulla=findViewById<ImageButton>(R.id.resum)
                val victory=findViewById<LinearLayout>(R.id.victory)
                val victoria=findViewById<TextView>(R.id.victoria)
                val extrastats=findViewById<TextView>(R.id.extrastats)
                victoria.setText("DERROTA")
                player.hp=player.def*5
                extrastats.visibility=View.GONE
                enemy1.hp=enemy1.def*5
                round.setText("RONDA 1")
                enemy2.hp=enemy1.def*5
                e1nemy.visibility=View.VISIBLE
                e2nemy.visibility=View.GONE
                batalla.visibility=View.GONE
                round.visibility=View.GONE
                victoria.visibility=View.VISIBLE
                val waifu=findViewById<ImageView>(R.id.waifu)
                waifu.visibility=View.VISIBLE
                fulla.visibility=View.VISIBLE
                victory.visibility=View.VISIBLE
                return

            }
            else{
            user_turn(player,enemy1,enemy2,diff)
            }
        }

    }
    override fun onBackPressed() {
        val intent = Intent(this@empty_activity, MainActivity::class.java)
        intent.putExtra("dmg", extradmg)
        intent.putExtra("def", extradef)
        intent.putExtra("vel",extravel)
        setResult(Activity.RESULT_OK, intent)
        super.onBackPressed()
        finish()
    }

}