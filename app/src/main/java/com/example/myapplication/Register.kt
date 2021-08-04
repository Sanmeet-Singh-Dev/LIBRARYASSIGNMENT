package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener {


            if (editEmail.text!!.trim().isNotEmpty() || editPassword.text!!.trim().isNotEmpty() || editCPassword.text!!.trim().isNotEmpty()) {
                registerUser()
            } else {
                Toast.makeText(this, "Input not provided", Toast.LENGTH_LONG).show()
            }
        }
        libLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun registerUser(){
        auth.createUserWithEmailAndPassword(editEmail.text!!.trim().toString(),editPassword.text!!.trim().toString())
            .addOnCompleteListener(this){
                    task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "Registration is Successful", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "Registration Unsuccessful"+task.exception, Toast.LENGTH_LONG).show()
                }

            }
    }



    override fun onStart(){
        super.onStart()
        val user = auth.currentUser;
     //    if(user!=null){

       //      val intent = Intent (this, Homepage::class.java)
         //    startActivity(intent)
        // }
       // else{
        //     Log.e("user status","user null")
        // }
    }
}