package com.example.trio.medicare.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trio.medicare.R
import com.example.trio.medicare.adapter.ApotekAdapter
import com.example.trio.medicare.api.ApiRepository
import com.example.trio.medicare.model.Apotek
import com.example.trio.medicare.presenter.ApotekPresenter
import com.example.trio.medicare.util.invisible
import com.example.trio.medicare.util.visible
import com.example.trio.medicare.view.ApotekView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_peta.*

class PetaFragment : Fragment(), ApotekView {

    private var apoteks: MutableList<Apotek> = mutableListOf()
    private lateinit var presenter: ApotekPresenter
    private lateinit var adapter: ApotekAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_peta, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ApotekAdapter(apoteks) {
//            context?.startActivity<DetailA>("match" to it)
        }
        rv_apotek.adapter = adapter
        rv_apotek.layoutManager = LinearLayoutManager(context)

        val request = ApiRepository()
        val gson = Gson()

        presenter = ApotekPresenter(this, request, gson)

        presenter.getApotek()

//        swipe_refresh.onRefresh {
//            presenter.getNextMatches(leagueId)
//        }
    }

    override fun showLoading() {
        activity?.progress_bar?.visible()
    }

    override fun hideLoading() {
        activity?.progress_bar?.invisible()
    }

    override fun showApoteks(data: List<Apotek>) {
        apoteks.clear()
        apoteks.addAll(data)
        adapter.notifyDataSetChanged()
    }

}