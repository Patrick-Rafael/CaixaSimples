package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.cs.R
import com.google.firebase.auth.FirebaseAuth



class activity_tela_de_inicio : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_inicio)
        auth = FirebaseAuth.getInstance();

        val botaoSair: Button = findViewById(R.id.buttonSinout)
        val botaoCaixaAdd: ImageButton = findViewById(R.id.buttonAdicionarCaixa)
        val campoInicial: EditText = findViewById(R.id.caixaInicial)

        var teste: TextView = findViewById(R.id.teste)

        //var campoCaixa = findViewById<EditText>(R.id.caixaInicial).text.toString().trim()



        botaoCaixaAdd.setOnClickListener {

            //teste.text = "Numero:" + campoInicial.text.toString().toInt()

            iniciarcaixaERedirecionar()
        }

        botaoSair.setOnClickListener{
            reloadOut()
        }
    }




    private fun iniciarcaixaERedirecionar(){
        intent = Intent(applicationContext, tela_principal::class.java)
        startActivity(intent)
        finish()
    }

    private fun reloadOut() {
        auth.signOut()
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}