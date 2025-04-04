package com.nihoi.jocestiu

import java.io.Serializable

class structures {
    data class Skill(
        val dmg: Int,
        val accuracy: Int,
        val crit: Int,
        val name: String
    )

    data class Element(
        val element: Int,
        val name: String,
        val strong: Array<Int?>,
        val skills: Array<Skill?>
    ) {
        companion object {
            val FIRE = Element(
                element = 0,
                name = "Fuego",
                strong = arrayOf(2, 5),
                skills = arrayOf(/* habilidades asociadas al fuego */)
            )
            val WATER = Element(
                element = 1,
                name = "Fuego",
                strong = arrayOf(0, 3),
                skills = arrayOf(/* habilidades asociadas al fuego */)
            )
            val PLANT = Element(
                element = 2,
                name = "Fuego",
                strong = arrayOf(3, 1),
                skills = arrayOf(/* habilidades asociadas al fuego */)
            )
            val EARTH = Element(
                element = 3,
                name = "Fuego",
                strong = arrayOf(4, 0),
                skills = arrayOf(/* habilidades asociadas al fuego */)
            )
            val THUNDER = Element(
                element = 4,
                name = "Fuego",
                strong = arrayOf(1),
                skills = arrayOf(/* habilidades asociadas al fuego */)
            )
            val ICE = Element(
                element = 5,
                name = "Fuego",
                strong = arrayOf(2),
                skills = arrayOf(/* habilidades asociadas al fuego */)
            )
        }
    }

        data class Spirit(
            val element: Element,
            val grade: Int,
            var lvl: Int,
            var name: String,
            var next: Spirit?
        )

        data class Player(
            var element: Element?,
            var lvl: Int,
            var hp: Int,
            var dmg: Int,
            var vel: Int,
            var def: Int,
            var exp: Int,
            var skills: Int,
            var progress:Int,
            var name: String,
            var spirit: Spirit?
        ) : Serializable
    }

