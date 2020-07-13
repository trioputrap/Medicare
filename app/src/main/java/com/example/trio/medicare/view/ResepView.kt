package com.example.trio.medicare.view

import com.example.trio.medicare.model.Resep

interface ResepView {
    fun showLoading()
    fun hideLoading()
    fun showReseps(data: List<Resep>)
}