package tema1A

import android.opengl.ETC1Util
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkodlin904.R

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var btn1: Button
    private lateinit var rg1: RadioGroup
    private lateinit var rd1: RadioButton
    private lateinit var rd2: RadioButton
    private lateinit var rd3: RadioButton
    private lateinit var rd4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        btn1 = findViewById(R.id.btn1)
        rg1 = findViewById(R.id.rg1)
        rd1 = findViewById(R.id.rd1)
        rd2 = findViewById(R.id.rd2)
        rd3 = findViewById(R.id.rd3)
        rd4 = findViewById(R.id.rd4)

        btn1.setOnClickListener {
            calcularOperacion()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun calcularOperacion() {
        val valor1Str = et1.text.toString()
        val valor2Str = et2.text.toString()

        if (valor1Str.isEmpty() || valor2Str.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val valor1 = valor1Str.toDouble()
            val valor2 = valor2Str.toDouble()
            var resultado = 0.0

            when (rg1.checkedRadioButtonId) {
                R.id.rd1 -> resultado = valor1 + valor2 // Suma
                R.id.rd2 -> resultado = valor1 - valor2 // Resta
                R.id.rd3 -> resultado = valor1 * valor2 // Multiplicación
                R.id.rd4 -> {
                    if (valor2 != 0.0) {
                        resultado = valor1 / valor2 // División
                    } else {
                        Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                        return
                    }
                }
            }

            tv1.text = "Resultado: $resultado"
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show()
        }
    }
}