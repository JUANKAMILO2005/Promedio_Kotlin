package com.juank.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity() : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCalcular:Button=findViewById(R.id.button)
        botonCalcular.setOnClickListener{onClick(1)}

        val botonPagina:Button=findViewById(R.id.button2)
        botonPagina.setOnClickListener{onClick(2)}

    }
    private fun onClick(boton: Int){
        val campoNombre:EditText=findViewById(R.id.editTextTextPersonName)
        val nombre:String=campoNombre.text.toString()

        val campoMateria:EditText=findViewById(R.id.editTextTextPersonName2)
        val materia:String=campoMateria.text.toString()

        val campoNota1:EditText=findViewById(R.id.editTextNumber)
        val nota1:Float=campoNota1.text.toString().toFloat()

        val campoNota2:EditText=findViewById(R.id.editTextNumber4)
        val nota2:Float=campoNota2.text.toString().toFloat()

        val campoNota3:EditText=findViewById(R.id.editTextNumber3)
        val nota3:Float=campoNota3.text.toString().toFloat()

        val mensajeResult:TextView=findViewById(R.id.tv)
        var prom:Float=(nota1+nota2+nota3)/3

        var result=""
        if (prom>=3.5){
            result="Ganó con promedio de $prom"
        }else{
            result="Perdió con promedio de $prom"
        }

        when(boton){
            1 ->{
                mensajeResult!!.text="Hola el estudante $nombre, $result la materia $materia"

                Toast.makeText(this,result,Toast.LENGTH_LONG).show()
            }
            2 ->{
                val intent = Intent(this,ActivityMensaje::class.java)
                val miBundle: Bundle = Bundle()
                miBundle.putFloat("nota1",nota1)
                miBundle.putFloat("nota2",nota2)
                miBundle.putFloat("nota3",nota3)
                miBundle.putString("materia",materia)
                miBundle.putString("nombre",nombre)
                miBundle.putString("resultado",result)
                intent.putExtras(miBundle)
                startActivity(intent)
            }
        }
    }
}

