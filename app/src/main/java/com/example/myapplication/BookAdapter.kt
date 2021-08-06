package com.example.myapplication

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_row1.view.*


class BookAdapter: RecyclerView.Adapter<BookAdapter.MyViewHolder>(){

    var items = ArrayList<RecyclerData>()

    fun setListData(data: ArrayList<RecyclerData>){
        this.items = data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row1,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val bookTitle = view.bookTitle
        val bookDescription = view.bookDescription
        val bookimageThumb = view.bookimageThumb


        fun bind(data:RecyclerData) {

            bookTitle.text = data.name

            if(!TextUtils.isEmpty(data.description)) {
                bookDescription.text = data.description
            }else{
                bookDescription.text = "No Description available"
            }
            val url = data.owner.avatar_url
            Glide.with(bookimageThumb)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.default_thumb)
                .error(R.drawable.default_thumb)
                .fallback(R.drawable.default_thumb)
                .into(bookimageThumb)

        }

    }


}