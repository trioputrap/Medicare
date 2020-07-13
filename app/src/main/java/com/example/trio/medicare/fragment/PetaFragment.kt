package com.example.trio.medicare.fragment

import android.content.Context.LOCATION_SERVICE
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trio.medicare.DetailApotekActivity
import com.example.trio.medicare.MainActivity
import com.example.trio.medicare.R
import com.example.trio.medicare.adapter.ApotekAdapter
import com.example.trio.medicare.api.ApiRepository
import com.example.trio.medicare.model.Apotek
import com.example.trio.medicare.presenter.ApotekPresenter
import com.example.trio.medicare.util.invisible
import com.example.trio.medicare.util.visible
import com.example.trio.medicare.view.ApotekView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_peta.*
import org.jetbrains.anko.startActivity

class PetaFragment : Fragment(), ApotekView {

    private var apoteks: MutableList<Apotek> = mutableListOf()
    private lateinit var presenter: ApotekPresenter
    private lateinit var adapter: ApotekAdapter

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context!!)
        return inflater.inflate(R.layout.fragment_peta, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ApotekAdapter(apoteks) {
            context?.startActivity<DetailApotekActivity>("apotek" to it)
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
        this.getLastKnownLocation()
    }

    fun getLastKnownLocation() {
        try{
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location->
                    if (location != null) {
                        Log.d("MapFound", "${location.latitude} , ${location.longitude}")
                    }

                }
        } catch (e : SecurityException){
            Log.d("myTag", "Security Exception, no location available")
        }


    }
}