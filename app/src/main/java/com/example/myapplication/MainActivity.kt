package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {


            if (libEmail.text!!.trim().isNotEmpty() || libPassword.text!!.trim().isNotEmpty()) {
                signInUser()
            }
            else{
                Toast.makeText(this, "Input not provided", Toast.LENGTH_LONG).show()
            }
        }
        libRegister.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }



    }



    fun signInUser(){
        auth.signInWithEmailAndPassword(libEmail.text.toString(),libPassword.text.toString())
            .addOnCompleteListener(this){
                task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Login verified", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, Homepage::class.java);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Error"+task.exception, Toast.LENGTH_LONG).show()
                }
            }
    }
    override fun onStart(){
        super.onStart()
        val user = auth.currentUser;
  //      if(user!=null){
//
  //          val intent = Intent (this, Homepage::class.java)
    //        startActivity(intent)
      //  }
        //else{
         //   Toast.makeText(this, "Please Login", Toast.LENGTH_LONG).show()
     //   }
    }

    }



