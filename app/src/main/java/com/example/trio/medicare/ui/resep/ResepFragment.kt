package com.example.trio.medicare.ui.resep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.trio.medicare.R

class ResepFragment : Fragment() {

    private lateinit var resepViewModel: ResepViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        resepViewModel =
                ViewModelProviders.of(this).get(ResepViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_resep, container, false)
        val textView: TextView = root.findViewById(R.id.text_resep)
        resepViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}