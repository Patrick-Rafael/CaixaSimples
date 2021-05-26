package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.cs.R

class tela_adcionar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_adcionar)

        val botaoSalvarAdd: ImageButton = findViewById(R.id.buttonSalvarAdd)

       botaoSalvarAdd.setOnClickListener {intent = Intent(applicationContext, tela_principal::class.java)
            startActivity(intent)}



    }
}