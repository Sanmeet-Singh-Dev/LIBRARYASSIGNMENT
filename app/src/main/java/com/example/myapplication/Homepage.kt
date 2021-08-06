package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_homepage.*

class Homepage : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        //like button
        animLike.setOnClickListener(){
            animLike.playAnimation()
        }
        animLike2.setOnClickListener(){
            animLike2.playAnimation()
        }
        animLike3.setOnClickListener(){
            animLike3.playAnimation()
        }



        auth = FirebaseAuth.getInstance()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_signOut -> {Toast.makeText(this, "Signed Out", Toast.LENGTH_LONG).show();
            auth.signOut()
            val logoutIntent = Intent(this,LoginActivity::class.java)
            logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(logoutIntent)
            }
            R.id.nav_feedBack -> {Toast.makeText(this, "Please give us your Valuable feedback.", Toast.LENGTH_LONG).show()
            val intent = Intent(this, FeedbackActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}