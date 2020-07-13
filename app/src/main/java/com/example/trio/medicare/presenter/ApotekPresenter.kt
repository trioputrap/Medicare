package com.example.trio.medicare.presenter

import com.example.trio.medicare.api.ApiRepository
import com.example.trio.medicare.api.ApotekDBApi
import com.example.trio.medicare.model.ApotekResponse
import com.example.trio.medicare.view.ApotekView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ApotekPresenter(
    private val view: ApotekView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getApotek() {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(ApotekDBApi.getApotek()),
                ApotekResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showApoteks(data.apoteks)
            }
        }
    }


}