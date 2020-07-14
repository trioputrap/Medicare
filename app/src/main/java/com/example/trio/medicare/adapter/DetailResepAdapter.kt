package com.example.trio.medicare.adapter

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trio.medicare.R
import com.example.trio.medicare.model.Apotek
import com.example.trio.medicare.model.Obat
import com.example.trio.medicare.util.toDateStringFormat
import kotlinx.android.synthetic.main.item_detail_resep.view.*
import kotlinx.android.synthetic.main.item_resep.view.*
import java.util.*

class DetailResepAdapter(private val obats: List<Obat>, private val listener: (View, Obat) -> Unit):
    RecyclerView.Adapter<DetailResepAdapter.DetailResepViewHolder>() {
    class DetailResepViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(obat: Obat, listener: (View, Obat) -> Unit) {
            itemView.tv_nama_obat.text = obat.nama
            itemView.tv_deskripsi.text = obat.description

            if(obat.status == 1){
                itemView.tv_r.apply { paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG }
                itemView.tv_nama_obat.apply { paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG }
                itemView.tv_deskripsi.apply { paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG }
            }

            itemView.setOnClickListener {
                listener(it, obat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailResepViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_detail_resep, parent, false))

    override fun getItemCount(): Int = obats.size

    override fun onBindViewHolder(holder: DetailResepViewHolder, position: Int) {
        holder.bindItem(obats[position], listener)
    }
}