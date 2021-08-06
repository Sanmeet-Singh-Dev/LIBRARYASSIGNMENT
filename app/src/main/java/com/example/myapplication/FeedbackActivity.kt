package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_feedback.*
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.zip.Inflater

class FeedbackActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("Users")
        btnSubmit.setOnClickListener{
            sendData()
        }



    }
    private fun sendData(){
        var name = fbeName.text.toString().trim()
        var rating = fbeRating.text.toString().trim()
        var message = fbeMessage.text.toString().trim()
        if (name.isNotEmpty() && rating.isNotEmpty() && message.isNotEmpty()){
            var model = DatabaseModel(name,rating,message)
            var id= reference.push().key
            //Sending data to firebase
            reference.child(id!!).setValue(model)
            Toast.makeText(this, "Feedback sent successfully", Toast.LENGTH_LONG).show()
            fbeMessage.setText("")
            fbeName.setText("")
            fbeRating.setText("")


        }else{
            Toast.makeText(this, "ALL FIELDS REQUIRED", Toast.LENGTH_LONG).show()
        }

    }
}