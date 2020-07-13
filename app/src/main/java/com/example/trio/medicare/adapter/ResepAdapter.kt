package com.example.trio.medicare.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trio.medicare.R
import com.example.trio.medicare.model.Resep
import com.example.trio.medicare.util.toDateStringFormat
import kotlinx.android.synthetic.main.item_resep.view.*
import java.util.*

class ResepAdapter(private val reseps: List<Resep>, private val listener: (Resep) -> Unit):
    RecyclerView.Adapter<ResepAdapter.ResepViewHolder>() {
    class ResepViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(resep: Resep, listener: (Resep) -> Unit) {
            itemView.tv_nama.text = resep.dokter.toString()
            itemView.tv_faskes.text = resep.faskes.toString()
            itemView.tv_total_obat.text = "${resep.jumlah_obat} Obat"
            itemView.tv_tanggal.text = resep.date
            if (resep.obat_tersisa == 0) {
                itemView.tv_sisa_obat.text = "Semua obat sudah diklaim"
                itemView.tv_sisa_obat.setTextColor(Color.parseColor("#03DAC5"))
            } else {
                itemView.tv_sisa_obat.text = "${resep.obat_tersisa} Obat belum diklaim"
                itemView.tv_sisa_obat.setTextColor(Color.parseColor("#6200EE"))
            }

            itemView.setOnClickListener { listener(resep) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ResepViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_resep, parent, false))


    override fun getItemCount(): Int = reseps.size

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        holder.bindItem(reseps[position], listener)
    }
}