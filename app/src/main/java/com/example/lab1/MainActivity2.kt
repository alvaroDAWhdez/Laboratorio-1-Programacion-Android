package com.example.lab1

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Selecciono todos los elementos del xml para trabajar con sus datos
        var textoNombre = findViewById<EditText>(R.id.textNombre)
        val spinnerRazas = findViewById<Spinner>(R.id.spinnerRazas)
        val rgBando = findViewById<RadioGroup>(R.id.rgBando)
        val checkSigilo = findViewById<CheckBox>(R.id.checkSigilo)
        val checkEspada = findViewById<CheckBox>(R.id.checkEspada)
        val btnRegister = findViewById<ImageButton>(R.id.btnRegister)

        //Le doy foco al EditText del nombre
        textoNombre.requestFocus()

        //Defino una función lambda para registrar la estructura en el Logcat
        val registrarEnLog: (String) -> Unit = { estructura ->
            Log.d("CREADOR_PERSONAJE", estructura)
        }

        btnRegister.setOnClickListener {
            //Extraer datos del formulario
            val nombre = textoNombre.text.toString()
            val raza = spinnerRazas.selectedItem.toString()

            //Extraigo el id y lo convierto a texto para mostrarlo en el log
            val idFaccion = rgBando.checkedRadioButtonId
            val faccion = when (idFaccion) {
                R.id.rbAnillo -> "Comunidad del Anillo"
                R.id.rbMordor -> "Huestes de Mordor"
                else -> "Sin facción"
            }

            //Variable para incluir los checkbox seleccionados, se concatenan segun se marquen
            var strHabilidades = ""
            if (checkSigilo.isChecked) {
                strHabilidades += "Sigilo"
            }

            if(checkEspada.isChecked){
                strHabilidades += ", Habilidad con espada"
            }

            //Si ninguna ha sido seleccionada, coge el valor de ninguna
            if (strHabilidades.isEmpty()) {
                strHabilidades = "Ninguna"
            }

            //Hacemos un resumen del contenido del formulario para el toast
            val resumen = "¡Personaje forjado!\nNombre: $nombre\nRaza: $raza\nFacción: $faccion\nHabilidades: $strHabilidades"

            //Y se dispara el toast
            Toast.makeText(this, resumen, Toast.LENGTH_LONG).show()

            //Llamamos a la funcion lambda para mostrar el log
            registrarEnLog("Personalización -> Nombre: $nombre | Raza: $raza | Faccion: $faccion | Habilidades: $strHabilidades .")

        }



    }
}