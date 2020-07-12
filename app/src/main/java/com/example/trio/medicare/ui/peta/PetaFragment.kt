package com.example.trio.medicare.ui.peta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.trio.medicare.R

class PetaFragment : Fragment() {

    private lateinit var petaViewModel: PetaViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        petaViewModel =
                ViewModelProviders.of(this).get(PetaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_peta, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        petaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}