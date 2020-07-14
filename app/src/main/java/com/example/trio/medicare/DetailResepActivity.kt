package com.example.trio.medicare

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trio.medicare.adapter.DetailResepAdapter
import com.example.trio.medicare.model.Obat
import com.example.trio.medicare.model.Resep
import com.example.trio.medicare.util.invisible
import com.example.trio.medicare.util.visible
import kotlinx.android.synthetic.main.activity_detail_resep.*
import org.jetbrains.anko.startActivity


class DetailResepActivity : AppCompatActivity() {
    private var resep: Resep? = null
    private val obats: MutableList<Obat> = ArrayList()
    private lateinit var adapter: DetailResepAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_resep)

        supportActionBar?.title = "Detail Resep"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.resep = intent.getParcelableExtra<Resep>("resep")
        showDetail(resep)
        btn_klaim.setOnClickListener {
            it.context.startActivity<KlaimActivity>()
        }
    }

    fun showDetail(resep: Resep?){
        tv_dokter.text = resep?.dokter
        tv_faskes.text = resep?.faskes
        tv_total_obat.text = "${resep?.jumlah_obat} Resep"
        tv_tempat_waktu.text = resep?.date
        tv_pro_val.text = resep?.pro
        tv_umur_val.text = resep?.usia.toString()

        adapter = DetailResepAdapter(resep!!.obats){
            view, obat ->

            if(obat.status ==0 ){
                obat.selected = !obat.selected

                val tv_r = view.findViewById<TextView>(R.id.tv_r)
                val tv_nama_obat = view.findViewById<TextView>(R.id.tv_nama_obat)
                val tv_deskripsi = view.findViewById<TextView>(R.id.tv_deskripsi)

                tv_r.setTextColor(Color.parseColor("#444444"))
                tv_nama_obat.setTextColor(Color.parseColor("#444444"))
                tv_deskripsi.setTextColor(Color.parseColor("#888888"))
                obats.remove(obat)
                if(obat.selected){
                    tv_r.setTextColor(Color.parseColor("#6200EE"))
                    tv_nama_obat.setTextColor(Color.parseColor("#6200EE"))
                    tv_deskripsi.setTextColor(Color.parseColor("#6200EE"))
                    obats.add(obat)
                }
            }

            if(obats.size > 0) btn_klaim.visible()
            else btn_klaim.invisible()

            Log.d("OBAT", obats.toString())
        }

        rv_resep.adapter = adapter
        rv_resep.layoutManager = LinearLayoutManager(applicationContext)
        adapter.notifyDataSetChanged()
    }
}