package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.cs.R

class tela_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

       val botaoAdd: ImageButton = findViewById(R.id.buttonAdicionar)
       val botaoRem: ImageButton = findViewById(R.id.buttonRemover)


        botaoAdd.setOnClickListener {intent = Intent(applicationContext, tela_adcionar::class.java)
            startActivity(intent)}


        botaoRem.setOnClickListener {intent = Intent(applicationContext, tela_adcionar::class.java)
            startActivity(intent)}




    }
}