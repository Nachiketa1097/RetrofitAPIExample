package com.example.retrofitapiexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapiexample.adapter.PostAdapter
import com.example.retrofitapiexample.controller.ApiServices
import com.example.retrofitapiexample.controller.ServiceBuilder
import com.example.retrofitapiexample.model.PostModelItem
import retrofit2.Call
import retrofit2.Response

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        loadData()
    }

    private fun loadData(){
        val add:Button = findViewById(R.id.btnAdd)
        val title:EditText = findViewById(R.id.etTitle)
        val body: EditText = findViewById(R.id.etBody)
        val userId:EditText = findViewById(R.id.etUserId)

        add.setOnClickListener {
            val service = ServiceBuilder.buildService(ApiServices::class.java)
            val model = PostModelItem(userId = userId.text.toString().toInt(),
                id = userId.text.toString().toInt(),
                title = title.text.toString(),
                body = body.text.toString())

            val requestCall1 = service.postData(model)

            requestCall1.enqueue(object :retrofit2.Callback<PostModelItem>{
                override fun onResponse(call: Call<PostModelItem>, response: Response<PostModelItem>) {
                    if (response.isSuccessful){
                        finish()
                        val list = response.body()!!
                        Toast.makeText(this@AddItemActivity,"Item Added successfully", Toast.LENGTH_LONG).show()
//                        val i =Intent(this@AddItemActivity, MainActivity::class.java)
//                        startActivity(i)
                    }
                    else{
                        Toast.makeText(this@AddItemActivity,"Something wrong 1", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<PostModelItem>, t: Throwable) {
                    Toast.makeText(this@AddItemActivity,"Something wrong 2", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    companion object{
        const val ARG_ITEM_ID = "item_id"
    }
}