package com.example.introkodlin904.polindromo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkodlin904.R

class PalindromoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)
        // Inicializar los botones y demas elementos
        val inputText = findViewById<EditText>(R.id.inputText)
        val analizarButton = findViewById<Button>(R.id.analizarButton)
        val errorText = findViewById<TextView>(R.id.errorText)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el botón para analizar el texto y saber si es un palíndromo
        analizarButton.setOnClickListener {
            val text = inputText.text.toString()
            if (text.isEmpty()) {
                errorText.text = "Por favor, ingresa un texto."
            } else {
                val resultado = verificar(text)
                if (resultado) {
                    //pasar los parametros a la siguiente actividad
                    val intent = android.content.Intent(this, ResultadoPalindromoActivity::class.java)
                    intent.putExtra("palindromo", text)
                    startActivity(intent)
                } else {
                    errorText.text = "$text no es un palíndromo."
                }
            }
        }
    }
    // Función para verificar si un texto es un palíndromo
    private fun verificar(text: String): Boolean {
        val cleanedText = text.replace("[^a-zA-ZáéíóúÁÉÍÓÚ]".toRegex(), "").lowercase()
        return cleanedText == cleanedText.reversed()
    }
}