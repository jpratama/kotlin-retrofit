package com.example.wisataindonesia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://udacoding.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Insert config ke interface request
        val request = retrofit.create(WisataService::class.java)

        request.requestAmbil()
            .enqueue(object : Callback<ResponseServer> {
                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                }

                override fun onResponse(call: Call<ResponseServer>, response: Response<ResponseServer>) {
                    Log.d("response server", response.body() ?.toString())

                    showData(response.body()?.data)
                }

            })
    }

    private fun showData(data: List<DataWisata>?) {
        list.adapter = data?.let { WisataAdapter(it) }
    }
}
