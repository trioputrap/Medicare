package com.example.trio.medicare.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trio.medicare.R
import com.example.trio.medicare.model.Obat
import com.example.trio.medicare.util.toDateStringFormat
import kotlinx.android.synthetic.main.item_resep.view.*
import java.util.*

class DetailApotekAdapter(private val obats: List<Obat>):
    RecyclerView.Adapter<DetailApotekAdapter.DetailApotekViewHolder>() {
    class DetailApotekViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(obat: Obat) {
            val text: TextView = itemView.findViewById(android.R.id.text1)
            text.text = obat.nama
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailApotekViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))

    override fun getItemCount(): Int = obats.size

    override fun onBindViewHolder(holder: DetailApotekViewHolder, position: Int) {
        holder.bindItem(obats[position])
    }
}