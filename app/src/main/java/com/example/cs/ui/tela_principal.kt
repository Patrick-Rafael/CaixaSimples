package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.cs.R
import com.google.firebase.auth.FirebaseAuth



class tela_principal :AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        auth = FirebaseAuth.getInstance();


        val botaoAdd: ImageButton = findViewById(R.id.buttonAdicionar)
        val botaoRem: ImageButton = findViewById(R.id.buttonRemover)




        botaoAdd.setOnClickListener {
            intent = Intent(applicationContext, tela_adcionar::class.java)
            startActivity(intent)
        }


        botaoRem.setOnClickListener {
            intent = Intent(applicationContext, tela_remover::class.java)
            startActivity(intent)
        }


    }

}