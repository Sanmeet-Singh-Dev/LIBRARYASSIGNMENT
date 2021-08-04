package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_homepage.*
import kotlinx.android.synthetic.main.activity_main.*

class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        libEntertainment.setOnClickListener(){
            val intent = Intent(this,EntertainmentActivity::class.java)
            startActivity(intent)
        }
        libBooks.setOnClickListener(){
            val intent = Intent(this,BooksActivity::class.java)
            startActivity(intent)
        }
        libApps.setOnClickListener(){
            val intent = Intent(this,AppActivity::class.java)
            startActivity(intent)
        }
    }
}