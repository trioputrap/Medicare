package com.example.trio.medicare.view

import com.example.trio.medicare.model.Apotek

interface ApotekView {
    fun showLoading()
    fun hideLoading()
    fun showApoteks(data: List<Apotek>)
}