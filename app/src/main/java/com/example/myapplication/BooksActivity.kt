package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.network.RetroInstance
import com.example.myapplication.network.RetroService
import kotlinx.android.synthetic.main.activity_entertainment.*
import retrofit2.Call
import retrofit2.Response

class BooksActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: BookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
        initRecyclerView()
        createData()
    }
    private fun initRecyclerView() {
        EntertainRecycler.apply {
            layoutManager = LinearLayoutManager(this@BooksActivity)
            recyclerViewAdapter = BookAdapter()
            adapter = recyclerViewAdapter
        }
    }
    fun createData() {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI("books")
        call.enqueue(object : retrofit2.Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    recyclerViewAdapter.setListData(response.body()?.items!!)
                    recyclerViewAdapter.notifyDataSetChanged()

                }
            }


            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                Toast.makeText(this@BooksActivity,"Error in getting data from API", Toast.LENGTH_LONG).show()
            }
        })
    }

}