package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class IntroductionAnim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introductionanim)
        val handler = Handler()
        handler.postDelayed({ val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)},3000)

    }





}



