package com.example.myapplication

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_row.view.*


class EntertainmentAdapter: RecyclerView.Adapter<EntertainmentAdapter.MyViewHolder>(){

    var items = ArrayList<RecyclerData>()

    fun setListData(data: ArrayList<RecyclerData>){
        this.items = data

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntertainmentAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }
    class MyViewHolder(view:View): RecyclerView.ViewHolder(view){

        val entertainmentTitle = view.entertainmentTitle
        val entertainmentDescription = view.entertainmentDescription
        val imageThumb = view.imageThumb


        fun bind(data:RecyclerData) {

            entertainmentTitle.text = data.name

               if(!TextUtils.isEmpty(data.description)) {
                   entertainmentDescription.text = data.description
               }else{
                   entertainmentDescription.text = "No Description available"
               }
            val url = data.owner.avatar_url
            Glide.with(imageThumb)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.default_thumb)
                .error(R.drawable.default_thumb)
                .fallback(R.drawable.default_thumb)
                .into(imageThumb)

            }

        }


    }


