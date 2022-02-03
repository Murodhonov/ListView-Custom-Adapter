package com.example.listviewcustomadapter

import Adapter.MyAdapter
import Cache.MySharedPreference
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_list_members.*

@Suppress("NAME_SHADOWING")
class ListUserActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_members)
        title = "Ro'yhatdan O'tganlar"


        MySharedPreference.init(this)
        val list = MySharedPreference.obektString
        myAdapter = MyAdapter(this, list)

        list_food.adapter = myAdapter

        list_food.setOnItemClickListener { parent, view, position, id ->

            val dialog = BottomSheetDialog(this)
            val view  = layoutInflater.inflate(R.layout.dialog,null)

            val name = view.findViewById<TextView>(R.id.txt_name_dialog)
            name.text = list[position].name
            val country = view.findViewById<TextView>(R.id.txt_country_dialog)
            country.text = list[position].country
            val phone = view.findViewById<TextView>(R.id.txt_number_dialog)
            phone.text = list[position].phone

            dialog.setCancelable(true)

            dialog.setContentView(view)

            dialog.show()

        }

    }
}