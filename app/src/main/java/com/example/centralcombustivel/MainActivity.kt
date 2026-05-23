package com.example.centralcombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnCalcularViagem = findViewById<Button>(R.id.btnCalcularViagem)
        val btnCompararCombustivel = findViewById<Button>(R.id.btnCompararCombustivel)
        val btnConsumoMensal = findViewById<Button>(R.id.btnConsumoMensal)
        val btnHistorico = findViewById<Button>(R.id.btnHistorico)
        val btnSobre = findViewById<Button>(R.id.btnSobre)
        val btnSair = findViewById<Button>(R.id.btnSair)


        btnCalcularViagem.setOnClickListener(){
            val intent = Intent(this, CalcularViagemActivity::class.java)
            startActivity(intent)
        }

        btnCompararCombustivel.setOnClickListener(){
            val intent = Intent(this, ConstrucaoActivity::class.java)
            startActivity(intent)
        }

        btnConsumoMensal.setOnClickListener(){
            val intent = Intent(this, ConstrucaoActivity::class.java)
            startActivity(intent)
        }

        btnHistorico.setOnClickListener(){
            val intent = Intent(this, ConstrucaoActivity::class.java)
            startActivity(intent)
        }

        btnSobre.setOnClickListener(){
            val intent = Intent(this, SobreActivity::class.java)
            startActivity(intent)
        }

        btnSair.setOnClickListener() {
            finishAffinity()
        }

    }
}