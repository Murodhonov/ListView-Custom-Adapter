package com.example.listviewcustomadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.menu).setOnClickListener{
            startActivity(Intent(this,ListFoodActivity::class.java))
        }
        findViewById<Button>(R.id.add_food).setOnClickListener{
            startActivity(Intent(this,AddFoodActivity::class.java))
        }

    }
}