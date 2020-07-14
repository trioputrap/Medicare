package com.example.trio.medicare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_resep.*
import kotlinx.android.synthetic.main.activity_klaim.*

class KlaimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_klaim)

        iv_close.setOnClickListener {
            finish()
        }

        btn_klaim.setOnClickListener {

        }
    }
}