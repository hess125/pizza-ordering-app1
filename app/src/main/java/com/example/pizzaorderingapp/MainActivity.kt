package com.example.pizzaorderingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun orderPg (view: View){
        val intnt = Intent (this, OrderActivity::class.java)
        startActivity(intnt)
    }
}