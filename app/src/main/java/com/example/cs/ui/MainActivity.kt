package com.example.cs.ui

import com.google.firebase.auth.FirebaseAuth


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cs.R


class MainActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth

    private val TAG: String = "Login"


    /*public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload();

        }
    }*/

    private fun reload() {
        intent = Intent(applicationContext, tela_principal::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)


        val botao: Button = findViewById(R.id.buttonEntrar)
        val botaoCadastro: TextView = findViewById(R.id.textCadastro)
        auth = FirebaseAuth.getInstance();



        botao.setOnClickListener {

            val email = findViewById<EditText>(R.id.login).text.toString().trim()
            val senha = findViewById<EditText>(R.id.senha).text.toString().trim()


            if (email.isEmpty() or senha.isEmpty()) {
                Toast.makeText(
                    baseContext, "Email ou senha invalidos",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        reload()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Algo esta incorreto",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        }

        botaoCadastro.setOnClickListener {

            intent = Intent(applicationContext, tela_cadastro::class.java)
            startActivity(intent)
        }

    }


}

