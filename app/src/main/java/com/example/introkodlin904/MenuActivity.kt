package com.example.introkodlin904

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnEjemplo1 = findViewById<Button>(R.id.btn1)
        val btnCinepolis = findViewById<Button>(R.id.btn2)
        val btnEjemplo2 = findViewById<Button>(R.id.btn3)
        val btnEjemplo3 = findViewById<Button>(R.id.btn4)
        val btnEjemplo4 = findViewById<Button>(R.id.btn5)
        btnEjemplo1.setOnClickListener {
            navigateToEjemplo1()
        }
        btnCinepolis.setOnClickListener {
            navigateToCinepolisAndroid()
        }
        btnEjemplo2.setOnClickListener {
        navigateToEjemplo2()
        }
        btnEjemplo3.setOnClickListener {
            navigateToEjemplo3()
        }
        btnEjemplo4.setOnClickListener {
            navigateToEjemplo4()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToEjemplo1() {
        val intent = android.content.Intent(this, tema1A.Ejemplo1Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToCinepolisAndroid() {
        val intent = android.content.Intent(this, practicas.cinepolisAndroid::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo2() {
        val intent = android.content.Intent(this, Tem2App.Ejemplo2Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo3() {
        val intent = android.content.Intent(this, com.example.introkodlin904.Tema3.Ejemplo3Activity::class.java)
        startActivity(intent)
    }
    private fun navigateToEjemplo4() {
        val intent = android.content.Intent(this, com.example.introkodlin904.Tema4.Ejemplo4Activity::class.java)
        startActivity(intent)
    }

}