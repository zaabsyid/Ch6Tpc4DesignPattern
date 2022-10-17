package com.zahirar.ch6tpc4designpattern.presenter

import com.zahirar.ch6tpc4designpattern.model.GetCarResponseItem

interface CarView {

    fun onSuccess(pesan : String, news : List<GetCarResponseItem>)
    fun onError(pesan : String)

}