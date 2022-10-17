package com.zahirar.ch6tpc4designpattern.presenter

import com.zahirar.ch6tpc4designpattern.model.GetCarResponseItem
import com.zahirar.ch6tpc4designpattern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter (val viewcar : CarView) {

    fun getDataCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<GetCarResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetCarResponseItem>>,
                    response: Response<List<GetCarResponseItem>>
                ) {
                    if (response.isSuccessful){
                        viewcar.onSuccess(response.message(), response.body()!!)
                    } else {
                        viewcar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetCarResponseItem>>, t: Throwable) {
                    viewcar.onError(t.message!!)
                }

            })
    }

}