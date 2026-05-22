package com.example.centralcombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoDistancia = findViewById<EditText>(R.id.campoDistancia)
        val campoAutonomia = findViewById<EditText>(R.id.campoAutonomia)
        val campoPreco = findViewById<EditText>(R.id.campoPreco)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val textoResultado = findViewById<TextView>(R.id.textoResultado)

        btnCalcular.setOnClickListener(){

            try {
                val distancia: Double = campoDistancia.text.toString().toDouble()
                val autonomia: Double = campoAutonomia.text.toString().toDouble()
                val preco: Double = campoPreco.text.toString().toDouble()

                if (autonomia == 0.0) {
                    Toast.makeText(
                        this,
                        "A autonomia não pode ser zero!",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@setOnClickListener
                }

                val consumo = distancia / autonomia;
                val gasto = consumo * preco

                textoResultado.setText(
                    " Distância: %.2f KM".format(distancia) +
                            "\n Consumo: %.2f Litros".format(consumo) +
                            "\n Gasto estimado: R$ %.2f".format(gasto)
                )
            } catch (e: Exception){
                Toast.makeText(
                    this,
                    "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}