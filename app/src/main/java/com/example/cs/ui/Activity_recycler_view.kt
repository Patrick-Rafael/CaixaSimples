package com.example.cs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs.R
import kotlin.random.Random


class Activity_recycler_view : AppCompatActivity(), ExampleAdapter.onItemClickListener{
    private val examplelist = generateDummyList(500)
    private val adapter = ExampleAdapter( examplelist, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recycler_view: RecyclerView = findViewById(R.id.recycler_view)


        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }

    fun inserirItem(view: View) {
        val index: Int = Random.nextInt(8)

        val newItem = ExampleItem(
            "Next item at position $index",
            "Line 2"
        )
        examplelist.add(index, newItem)
        adapter.notifyItemInserted(index)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked",Toast.LENGTH_SHORT).show()
        val clickedItem: ExampleItem = examplelist[position]
        clickedItem.produto = "Clicked"
        adapter.notifyItemChanged(position)
    }

    fun removerItem(view: View) {
        val index: Int = Random.nextInt(8)

        examplelist.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_teste
                1 -> R.drawable.ic_teste
                else -> R.drawable.ic_teste
            }

        }
        return list
    }
}