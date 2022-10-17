package com.zahirar.ch6tpc4designpattern.network

import com.zahirar.ch6tpc4designpattern.model.GetCarResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar() : Call<List<GetCarResponseItem>>
}