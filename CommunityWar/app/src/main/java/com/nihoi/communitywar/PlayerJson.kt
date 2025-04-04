package com.nihoi.communitywar
import android.content.Context
import com.google.gson.Gson
import android.content.SharedPreferences

class PlayerPreferences(context: Context) {
    private val PREF_NAME = "PlayerPreferences"
    private val KEY_PLAYER_MODEL = "playerModel"

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    fun savePlayerModel(playerModel: PlayersModel) {
        val playerModelJson = gson.toJson(playerModel)
        preferences.edit().putString(KEY_PLAYER_MODEL, playerModelJson).apply()
    }

    fun getPlayerModel(): PlayersModel? {
        val playerModelJson = preferences.getString(KEY_PLAYER_MODEL, null)
        return if (playerModelJson != null) {
            gson.fromJson(playerModelJson, PlayersModel::class.java)
        } else {
            null
        }
    }

    fun clearPlayerModel() {
        preferences.edit().remove(KEY_PLAYER_MODEL).apply()
    }
}
