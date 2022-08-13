package com.example.retrofitapiexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapiexample.adapter.PostAdapter
import com.example.retrofitapiexample.controller.ApiServices
import com.example.retrofitapiexample.controller.ServiceBuilder
import com.example.retrofitapiexample.model.PostModelItem
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val add : Button = findViewById(R.id.button)

        add.setOnClickListener {
            val i = Intent(this@MainActivity, AddItemActivity::class.java)
            startActivity(i)
        }
        loadData()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData(){
        val recyclerView:RecyclerView = findViewById(R.id.rv)
        val tv:TextView = findViewById(R.id.textView5)

        val service = ServiceBuilder.buildService(ApiServices::class.java)
        val requestCall1 = service.getPostData()
//       val requestCall1 = service.getFilteredPostsData(1)
//       val requestCall1 = service.getAllFilteredPostsDataUsingMultipleQuery(1,1)

        val filter = HashMap<String, Int>()
        filter.put("userId", 1)
        filter.put("id",1)
//       val requestCall1 = service.getAllFilteredPostsDataUsingQueryMap(filter)

        requestCall1.enqueue(object :retrofit2.Callback<List<PostModelItem>> {
            override fun onResponse(call: Call<List<PostModelItem>>, response: Response<List<PostModelItem>>) {
                if (response.isSuccessful){
                    val list = response.body()!!
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    recyclerView.adapter = PostAdapter(list)
                    tv.text = list.size.toString()
                }
                else{
                    Toast.makeText(this@MainActivity,"Something wrong 1", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<PostModelItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Something wrong 2", Toast.LENGTH_LONG).show()
            }
        })

//        val requestCall = service.getPostDataId(20)
//
//        requestCall.enqueue(object :retrofit2.Callback<PostModelItem> {
//            @SuppressLint("SetTextI18n")
//            override fun onResponse(call: Call<PostModelItem>, response: Response<PostModelItem>) {
//                if (response.isSuccessful){
//                    val list = response.body()!!
//                    list.let {
//                        tv.text ="${it.id}\n ${it.title} \n ${it.userId} \n ${it.body}"
//                    }
//                }
//                else{
//                    Toast.makeText(this@MainActivity,"Something wrong 3", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<PostModelItem>, t: Throwable) {
//                Toast.makeText(this@MainActivity,"Something wrong 4", Toast.LENGTH_LONG).show()
//            }
//        })
    }
}