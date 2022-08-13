package com.example.retrofitapiexample.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapiexample.AddItemActivity
import com.example.retrofitapiexample.R
import com.example.retrofitapiexample.model.PostModelItem

class PostAdapter(private val list: List<PostModelItem>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val title: TextView
         val body: TextView
         val id: TextView

        init {
            title = view.findViewById(R.id.textView)
            body = view.findViewById(R.id.textView2)
            id = view.findViewById(R.id.textView3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.body.text = list[position].body
        holder.id.text = "Id = ${list[position].id.toString()}"

//        holder.itemView.setOnClickListener { v ->
//            val context = v.context
//            val intent = Intent(context, AddItemActivity::class.java)
//            intent.putExtra(AddItemActivity.ARG_ITEM_ID, list[position].id)
//
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}