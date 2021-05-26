package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.cs.R

class tela_remover : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_remover)

        val botaoRem2: ImageButton = findViewById(R.id.buttonSalvarRem)


        botaoRem2.setOnClickListener {intent = Intent(applicationContext, tela_principal::class.java)
            startActivity(intent)}


    }
}