package com.example.listviewcustomadapter

import Cache.MySharedPreference
import Utils.MyData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_food.*

class AboutFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_food)
        supportActionBar?.hide()

        MySharedPreference.init(this)
        val list = MySharedPreference.obektString
        val position = intent.getIntExtra("position",0)

        txt_name.text = list[position].name
        txt_food_product.text = list[position].ingradients
        txt_preparation_order.text = list[position].preparationOrder
    }
}