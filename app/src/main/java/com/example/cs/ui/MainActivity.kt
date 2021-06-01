package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cs.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao: Button = findViewById(R.id.buttonEntrar)
        val botaoCadastro: TextView = findViewById(R.id.textCadastro)

       botao.setOnClickListener {intent = Intent(applicationContext, tela_principal::class.java)
            startActivity(intent)}

        botaoCadastro.setOnClickListener {intent = Intent(applicationContext, tela_cadastro::class.java)
            startActivity(intent)}

    }
}