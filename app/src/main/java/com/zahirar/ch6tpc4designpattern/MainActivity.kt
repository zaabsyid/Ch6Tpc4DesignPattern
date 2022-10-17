package com.zahirar.ch6tpc4designpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zahirar.ch6tpc4designpattern.databinding.ActivityMainBinding
import com.zahirar.ch6tpc4designpattern.model.GetCarResponseItem
import com.zahirar.ch6tpc4designpattern.presenter.CarPresenter
import com.zahirar.ch6tpc4designpattern.presenter.CarView
import com.zahirar.ch6tpc4designpattern.view.CarAdapter

class MainActivity : AppCompatActivity(), CarView {

    lateinit var binding : ActivityMainBinding
    private lateinit var presenterCar : CarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenterCar = CarPresenter(this)
        presenterCar.getDataCar()
    }

    override fun onSuccess(pesan: String, car : List<GetCarResponseItem>){
        binding.rvListCar.layoutManager = LinearLayoutManager(this)
        binding.rvListCar.adapter = CarAdapter(car)
    }

    override fun onError(pesan: String){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }
}