package practicas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkodlin904.R

class cinepolisAndroid : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis_android)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCompradores = findViewById<EditText>(R.id.etCompradores)
        val rbSi = findViewById<RadioButton>(R.id.rbSi)
        val rbNo = findViewById<RadioButton>(R.id.rbNo)
        val etBoletos = findViewById<EditText>(R.id.etBoletos)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            if (etNombre.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (etCompradores.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese cantidad de compradores", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (etBoletos.text.toString().isEmpty()) {
                Toast.makeText(this, "Ingrese cantidad de boletos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val nombre = etNombre.text.toString()
            val compradores = etCompradores.text.toString().toInt()
            val boletos = etBoletos.text.toString().toInt()
            val tieneTarjeta = rbSi.isChecked
            val precioBoleto = 12000.0


            if (boletos > 7 * compradores) {
                Toast.makeText(this, "Máximo 7 boletos por persona", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Calcular subtotal
            var subtotal = boletos * precioBoleto

            // Aplicar descuentos según cantidad de boletos
            var descuento = 0.0
            when {
                boletos > 5 -> descuento = subtotal * 0.15
                boletos in 3..5 -> descuento = subtotal * 0.10
            }

            var total = subtotal - descuento

            // Aplicar descuento adicional por tarjeta Cineco
            if (tieneTarjeta) {
                val descuentoTarjeta = total * 0.10
                total -= descuentoTarjeta
            }


            tvTotal.text = "$${"%.2f".format(total)}"


            Toast.makeText(this,
                "$nombre: ${boletos} boletos, Total: $${"%.2f".format(total)}",
                Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}