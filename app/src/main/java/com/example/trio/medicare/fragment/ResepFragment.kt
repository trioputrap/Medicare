package com.example.trio.medicare.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trio.medicare.DetailApotekActivity
import com.example.trio.medicare.R
import com.example.trio.medicare.adapter.ResepAdapter
import com.example.trio.medicare.api.ApiRepository
import com.example.trio.medicare.model.Resep
import com.example.trio.medicare.presenter.ResepPresenter
import com.example.trio.medicare.util.Constant
import com.example.trio.medicare.util.invisible
import com.example.trio.medicare.util.visible
import com.example.trio.medicare.view.ResepView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_resep.*
import org.jetbrains.anko.startActivity

class ResepFragment : Fragment(), ResepView {
    private var reseps: MutableList<Resep> = mutableListOf()
    private lateinit var presenter: ResepPresenter
    private lateinit var adapter: ResepAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resep, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ResepAdapter(reseps) {
            context?.startActivity<DetailApotekActivity>("apotek" to it)
        }
        rv_resep.adapter = adapter
        rv_resep.layoutManager = LinearLayoutManager(context)

        val request = ApiRepository()
        val gson = Gson()

        presenter = ResepPresenter(this, request, gson)

        presenter.getResep(Constant.USER_ID)

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

    override fun showReseps(data: List<Resep>) {
        reseps.clear()
        reseps.addAll(data)
        adapter.notifyDataSetChanged()
    }

}