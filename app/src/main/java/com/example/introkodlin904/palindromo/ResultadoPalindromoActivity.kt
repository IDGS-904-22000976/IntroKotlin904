package com.example.introkodlin904.palindromo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkodlin904.R

class ResultadoPalindromoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_palindromo)
        val resultado = intent.extras?.getString("palindromo").orEmpty()
        val tvResultado = findViewById<TextView>(R.id.resultText)

        val original = resultado
        // esta cosa es para invertir la cadena
        val invertida = original.reversed()
        // esta cosa es para filtrar las vocales y consonantes
        val vocales = original.filter { it.lowercaseChar() in "aeiouáéíóú" }
        val consonantes = original.filter { it.isLetter() && it.lowercaseChar() !in "aeiouáéíóú" }

        // Creamos el mensaje y usamos trimIndent para formatear el texto para que se vea bien :D
        val mensaje = """
            Cadena original: $original
            Cadena invertida: $invertida
            Vocales: $vocales
            Consonantes: $consonantes
        """.trimIndent()

        tvResultado.text = mensaje

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}