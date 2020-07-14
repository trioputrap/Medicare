package com.example.trio.medicare

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trio.medicare.adapter.ApotekAdapter
import com.example.trio.medicare.adapter.DetailApotekAdapter
import com.example.trio.medicare.model.Apotek
import kotlinx.android.synthetic.main.activity_detail_apotek.*
import kotlinx.android.synthetic.main.fragment_peta.*
import org.jetbrains.anko.startActivity
import java.util.*


class DetailApotekActivity : AppCompatActivity() {
    private var apotek: Apotek? = null
    private lateinit var adapter: DetailApotekAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_apotek)

        supportActionBar?.title = "Detail Apotek"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.apotek = intent.getParcelableExtra<Apotek>("apotek")
        showDetail(apotek)

        btn_map.setOnClickListener { view ->
            val gmmIntentUri =
                Uri.parse("google.navigation:q=${apotek?.lat},${apotek?.long}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)


        }
    }

    fun showDetail(apotek: Apotek?){
        tv_nama.text = apotek?.nama
        tv_alamat.text = apotek?.alamat
        tv_waktu.text = "${apotek?.open} – ${apotek?.closed}"
        tv_total_obat.text = "${apotek?.obat_cocok} Obat"
        Log.e("TEST", apotek!!.obats.toString())
        adapter = DetailApotekAdapter(apotek!!.obats)
        rv_obat.adapter = adapter
        rv_obat.layoutManager = LinearLayoutManager(applicationContext)
        adapter.notifyDataSetChanged()
    }
}