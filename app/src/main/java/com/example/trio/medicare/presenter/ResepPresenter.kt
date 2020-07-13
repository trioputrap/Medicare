package com.example.trio.medicare.presenter

import com.example.trio.medicare.api.ApiRepository
import com.example.trio.medicare.api.ApotekDBApi
import com.example.trio.medicare.model.ResepResponse
import com.example.trio.medicare.view.ResepView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ResepPresenter(
    private val view: ResepView,
    private val apiRepository: ApiRepository,
    private val gson: Gson
) {
    fun getResep(user_id : Int) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(
                apiRepository
                    .doRequest(ApotekDBApi.getResep(user_id)),
                ResepResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showReseps(data.reseps)
            }
        }
    }


}