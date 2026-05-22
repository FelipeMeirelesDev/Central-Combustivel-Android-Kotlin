package com.example.centralcombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoDistancia = findViewById<EditText>(R.id.campoDistancia)
        val campoAutonomia = findViewById<EditText>(R.id.campoAutonomia)
        val campoPreco = findViewById<EditText>(R.id.campoPreco)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

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

                val mensagem =
                    "\nDistância: %.2f KM".format(distancia) +
                            "\n\nConsumo: %.2f Litros".format(consumo) +
                            "\n\nGasto estimado: R$ %.2f".format(gasto)

                AlertDialog.Builder(this)
                    .setTitle("Resultado da Viagem:")
                    .setMessage(mensagem)
                    .setPositiveButton("OK", null)
                    .show()
            } catch (e: Exception){
                Toast.makeText(
                    this,
                    "Preencha todos os campos corretamente!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        btnLimpar.setOnClickListener(){
            try {
                campoDistancia.setText(null)
                campoAutonomia.setText(null)
                campoPreco.setText(null)
            } catch (e : Exception){
                Toast.makeText(
                    this,
                    "Ocorreu um erro!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}