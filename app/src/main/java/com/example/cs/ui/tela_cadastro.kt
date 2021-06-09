package com.example.cs.ui

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cs.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


private lateinit var auth: FirebaseAuth


class tela_cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)

        auth = FirebaseAuth.getInstance()


        val emailCadastro: EditText = findViewById(R.id.emailCadastro)
        val senhaCadastro: EditText = findViewById(R.id.senhaCadastro)
        val botaoCadastro: Button = findViewById(R.id.buttonCadastro)


        botaoCadastro.setOnClickListener {

            val emailTexto: String = emailCadastro.text.toString()
            val senhaTexto: String = senhaCadastro.text.toString()

            auth.createUserWithEmailAndPassword(emailTexto, senhaTexto)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        reloadCadastro()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Este Usuario já existe",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
        }

    }

    private fun reloadCadastro() {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}

