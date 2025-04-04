package com.nihoi.childtoman;

import androidx.core.app.JobIntentService;
import java.util.Locale;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.core.app.JobIntentService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReinicioDiarioService extends JobIntentService {

    // Identificador único para el servicio
    private static final int JOB_ID = 1000;
    @Override
    protected void onHandleWork(Intent intent) {
        reiniciarPuntuacionDiaria();
    }

    private void reiniciarPuntuacionDiaria() {
        // Obtener la referencia a las preferencias compartidas
        SharedPreferences pref = getSharedPreferences("llave_principal", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        // Reiniciar la puntuación diaria a 0

        editor.putInt("dailyScore", 0);
        editor.putInt("dailyMissions",0);
        editor.apply();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String fechaActual = dateFormat.format(new Date());
        String ultimaFechaJugada = pref.getString("ultimaFechaJugada", "");

        // Verificar si el usuario ya jugó hoy
        if (ultimaFechaJugada.equals(fechaActual)) {
            int racha=pref.getInt("racha",1);
            editor.putInt("racha",racha+1);
            editor.apply();
        } else {
            editor.putInt("racha",1);
            editor.apply();
        }

    }
}

