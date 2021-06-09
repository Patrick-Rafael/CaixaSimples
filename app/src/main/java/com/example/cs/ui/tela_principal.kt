package com.example.cs.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class tela_principal : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var dbref: DatabaseReference
    private lateinit var itemRecyclerview: RecyclerView
    private lateinit var itemArrayList: ArrayList<ExampleItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)
        auth = FirebaseAuth.getInstance()

        dbref = FirebaseDatabase.getInstance().getReference("items")

        itemRecyclerview = findViewById(R.id.recycler_view)
        itemRecyclerview.layoutManager = LinearLayoutManager(this)
        itemArrayList = arrayListOf<ExampleItem>()
        getUserData()

        val botaoAdd: FloatingActionButton = findViewById(R.id.buttonAdicionar)



        botaoAdd.setOnClickListener {
            intent = Intent(applicationContext, tela_adcionar::class.java)
            startActivity(intent)
        }


        val list = arrayListOf<ExampleItem>()
       // list.add(ExampleItem("5","Café",6,"3","Carlos Antonio","5","06","2021","ss"))




        val recycleteste = findViewById<RecyclerView>(R.id.recycler_view)
        recycleteste.layoutManager = LinearLayoutManager(applicationContext)
        recycleteste.adapter = ExampleAdapter(list)



    }

    private fun getUserData() {

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (itemSnapshot in snapshot.children){

                        val items = itemSnapshot.getValue<ExampleItem>()
                        itemArrayList.add(items!!)

                    }

                    itemRecyclerview.adapter = ExampleAdapter(itemArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}
