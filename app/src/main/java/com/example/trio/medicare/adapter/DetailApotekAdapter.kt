package com.example.trio.medicare.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trio.medicare.R
import com.example.trio.medicare.model.Obat
import com.example.trio.medicare.util.toDateStringFormat
import kotlinx.android.synthetic.main.item_resep.view.*
import java.util.*

class DetailApotekAdapter(private val obats: List<Obat>, private val listener: (Obat) -> Unit):
    RecyclerView.Adapter<DetailApotekAdapter.ResepViewHolder>() {
    class ResepViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(resep: Obat, listener: (Obat) -> Unit) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ResepViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_resep, parent, false))


    override fun getItemCount(): Int = obats.size

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        holder.bindItem(obats[position], listener)
    }
}