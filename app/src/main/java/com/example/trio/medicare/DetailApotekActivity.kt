package com.example.trio.medicare

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.trio.medicare.model.Apotek
import kotlinx.android.synthetic.main.activity_detail_apotek.*
import java.util.*


class DetailApotekActivity : AppCompatActivity() {
    private var apotek: Apotek? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_apotek)

        supportActionBar?.title = "Match Detail"
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

    }
}