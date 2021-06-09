package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.cs.R
import com.example.cs.data.ItemViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase

private var database = FirebaseDatabase.getInstance().getReference()

private lateinit var itemViewModel: ItemViewModel


class tela_adcionar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_adcionar)

        val botaoSalvarAdd: Button = findViewById(R.id.buttonSalvarAdd)

        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)





        botaoSalvarAdd.setOnClickListener {

            val produto = findViewById<EditText>(R.id.produto).text.toString().trim()
            val valor = findViewById<EditText>(R.id.valorAdd).text.toString().trim()
            val quantidade = findViewById<EditText>(R.id.quantidade).text.toString().trim()
            val cliente = findViewById<EditText>(R.id.cliente).text.toString().trim()


            if (produto.isEmpty()) {
                val etproduto: EditText = findViewById(R.id.produto)
                etproduto.error = "Campo Obrigatório"
                return@setOnClickListener
            }

            if (valor.isEmpty()) {
                val etvalor: EditText = findViewById(R.id.valorAdd)
                etvalor.error = "Campo Obrigatório"
                return@setOnClickListener
            }

            if (quantidade.isEmpty() && quantidade.toInt() > 0) {
                val etquantidade: EditText = findViewById(R.id.quantidade)
                etquantidade.error = "Campo Obrigatório"
                return@setOnClickListener
            }

            if (cliente.isEmpty()) {
                val etcliente: EditText = findViewById(R.id.cliente)
                etcliente.error = "Campo Obrigatório"
                return@setOnClickListener
            }


            val item = ExampleItem(
                null,
                produto,
                valor.toInt(),
                quantidade,
                cliente,
                "09",
                "06",
                "2021",
                "sim"
            )

            itemViewModel.addItem(item)

            intent = Intent(applicationContext, tela_principal::class.java)
            startActivity(intent)

            finish()
        }


    }


    private fun pegarNumero() {

        val numero = findViewById<EditText>(R.id.valorAdd).text.toString().trim()


    }

    private fun validacao() {

    }


}


