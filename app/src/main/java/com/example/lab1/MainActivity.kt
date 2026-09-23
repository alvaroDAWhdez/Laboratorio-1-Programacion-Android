package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Contador de miembros reunidos
    var numMiembros = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Selecciono los elementos creados a traves de tu id
        var btnForjar = findViewById<Button>(R.id.btnForjar)
        var textoMiembros = findViewById<TextView>(R.id.numMiembros)

        //A traves del evento click del boton aumento el numero de miembros y los muestro por pantalla
        btnForjar.setOnClickListener {
            numMiembros= numMiembros + 1
            textoMiembros.text = "Miembros reunidos: " + numMiembros

        }
    }
}