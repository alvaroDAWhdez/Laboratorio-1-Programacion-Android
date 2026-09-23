package com.example.lab1

import android.os.Bundle
import android.util.Log
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
        Log.d("Inicio", "Se esta creando la comunidad del anillo en Rivendel")
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

            Log.d("Miembro añadido","Un nuevo miembro ha sido añadido a la comunidad del anillo")

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Comienzo","La aplicacion se esta iniciando para forjar la comunidad del anillo")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Avance del viaje","El viaje continua sin contratiempos ni baja ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Pausa","El ojo de Sauron nos permite tomarnos un descanso")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Final","El anillo ha sido destruido, la mision ha sido completada")
    }
}