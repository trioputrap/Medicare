package com.example.trio.medicare.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trio.medicare.R
import com.example.trio.medicare.model.Apotek
import kotlinx.android.synthetic.main.item_apotek.view.*

class ApotekAdapter(private val apoteks: List<Apotek>, private val listener: (Apotek) -> Unit):
    RecyclerView.Adapter<ApotekAdapter.ApotekViewHolder>() {
    class ApotekViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(apotek: Apotek, listener: (Apotek) -> Unit) {
            itemView.tv_nama.text = apotek.nama.toString()
            itemView.tv_alamat.text = apotek.alamat.toString()
            if (apotek.obat_cocok == 0) {
                itemView.tv_info_obat.text = "Tidak ditemukan obat yang diperlukan"
                itemView.tv_info_obat.setTextColor(Color.parseColor("#03DAC5"))
                itemView.iv_obat.setColorFilter(Color.parseColor("#03DAC5"))
            } else {
                itemView.tv_info_obat.text = "${apotek.obat_cocok} Obat dari resep tersedia"
                itemView.tv_info_obat.setTextColor(Color.parseColor("#6200EE"))
                itemView.iv_obat.setColorFilter(Color.parseColor("#6200EE"))
            }

            itemView.setOnClickListener { listener(apotek) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ApotekViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_apotek, parent, false))


    override fun getItemCount(): Int = apoteks.size

    override fun onBindViewHolder(holder: ApotekViewHolder, position: Int) {
        holder.bindItem(apoteks[position], listener)
    }
}