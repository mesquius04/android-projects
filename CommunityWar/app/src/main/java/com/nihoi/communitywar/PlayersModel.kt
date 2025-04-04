package com.nihoi.communitywar

data class PlayersModel (
    var playerId:String="null",
    var playerName:String="null",
    var lvl:Int=1,
    var password:String="null",
    var email:String="null",
    var exp:Int=0,
    var daily:Int=0,
    var totalsc:Int=0,
    var type:Int=0,
    var castleName:String=""
)
