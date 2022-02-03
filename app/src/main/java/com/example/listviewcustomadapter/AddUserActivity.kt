package com.example.listviewcustomadapter

import Cache.MySharedPreference
import Models.User
import Utils.MyData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_food.*

@Suppress("DEPRECATION")
class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        MySharedPreference.init(this)

        selectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        }

        btn_save.setOnClickListener {
            val name = edit_name.text.toString().trim()
            val country = edit_country.text.toString().trim()
            val phone = edit_phone.text.toString().trim()

            if (name != "" && country != "" && phone != "") {
                MyData.userList.add(User(name, country, phone))
                val list = MySharedPreference.obektString
                list.add(User(name, country, phone))
                MySharedPreference.obektString = list
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Malumotlarni to'liq kiriting", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 456) {
            selectImage.setImageURI(data?.data)
        }
    }
}