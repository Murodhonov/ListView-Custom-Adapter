package com.example.listviewcustomadapter

import Cache.MySharedPreference
import Models.Food
import Utils.MyData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_food.*

class AddFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        MySharedPreference.init(this)

        btn_save.setOnClickListener {
            val name = edit_food_name.text.toString().trim()
            val product = edit_food_products.text.toString().trim()
            val preparationOrder = edit_preparation_order.text.toString().trim()

            if (name != "" && product != "" && preparationOrder != "") {
                MyData.foodList.add(Food(name, product, preparationOrder))
                val list = MySharedPreference.obektString
                list.add(Food(name, product, preparationOrder))
                MySharedPreference.obektString = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}