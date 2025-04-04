package com.nihoi.jocestiu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Sect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sect)
        var lvl=intent.getIntExtra("lvl",1)
        var dmg=intent.getIntExtra("dmg",1)
        var def=intent.getIntExtra("def",1)
        var vel=intent.getIntExtra("vel",1)
        var exp=intent.getIntExtra("exp",1)
        var name=intent.getStringExtra("name")
        var element=intent.getIntExtra("element",1)
        var progres=intent.getIntExtra("progress",0)
        var player= structures.Player(
            structures.Element.FIRE,
            lvl,
            5 * def,
            dmg,
            vel,
            def,
            exp,
            3,
            progres,
            name.toString(),
            null
        )




    }

}