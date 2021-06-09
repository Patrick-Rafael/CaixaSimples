package com.example.cs.ui


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs.R
import org.w3c.dom.Text

class ExampleAdapter(
    private val examplelist: List<ExampleItem>,
    //private val listener: onItemClickListener
) :
    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.example_item,
            parent, false
        )

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = examplelist[position]

        holder.produto.text = currentItem.produto
        holder.preco.text = "$" + currentItem.valorUnitario
        holder.quantidade.text =currentItem.quantidade
    }

    override fun getItemCount() = examplelist.size

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
         {

        val produto: TextView = itemView.findViewById(R.id.produto)
        val preco: TextView = itemView.findViewById(R.id.preco)
        val quantidade: TextView = itemView.findViewById(R.id.quantidade)


       /*init {
            itemView.setOnClickListener(this)
        }

      override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface onItemClickListener {
        fun onItemClick(position: Int)*/

    }
}

