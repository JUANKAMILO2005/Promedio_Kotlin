package com.juank.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ActivityMensaje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        val mesajeMensaje = findViewById<TextView>(R.id.tv2)
        var miBundle: Bundle? = this.intent.extras
        if (miBundle != null){
            mesajeMensaje.text="Hola el estudiante ${miBundle.getString("nombre")}, ${miBundle.getString("resultado")} la materia ${miBundle.getString("materia")}. \nNota 1: ${miBundle.getFloat("nota1")} \nNota 2: ${miBundle.getFloat("nota2")} \nNota 3: ${miBundle.getFloat("nota3")} \n"
        }
    }

    fun SALIR(view: View) {
        finish();
    }
}