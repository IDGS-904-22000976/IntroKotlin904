package tema1A

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkodlin904.R

class MultiplicacionConSuma : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplicacion_con_suma)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {
            calcularMultiplicacionConSumas()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calcularMultiplicacionConSumas() {
        val valor1Str = et1.text.toString()
        val valor2Str = et2.text.toString()

        if (valor1Str.isEmpty() || valor2Str.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val a = valor1Str.toInt()
            val b = valor2Str.toInt()

            var resultado = 0
            var proceso = "Proceso: "

            for (i in 1..b) {
                resultado += a
                proceso += if (i > 1) " + $a" else "$a"
            }

            tv1.text = "$proceso = $resultado"
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese números enteros válidos", Toast.LENGTH_SHORT).show()
        }
    }
}