package com.example.atorapp.http


import android.util.Log
import okhttp3.MediaType
import	okhttp3.OkHttpClient
import	okhttp3.Request
import okhttp3.RequestBody


class HttpHelper {

    fun post (json: String) : String {

        val URL = "https://jsonplaceholder.typicode.com/todos/1"

        val headerHttp = MediaType.parse("application/json; charset=utf-8")

        val client = OkHttpClient()

        val body = RequestBody.create(headerHttp, json)

        var request = Request.Builder().url(URL).post(body).build()

        val response = client.newCall(request).execute()

        return response.body().toString()

    }
    fun get(){

        val URL = "https://jsonplaceholder.typicode.com/todos/1"

        val client = OkHttpClient()



        var request = Request.Builder().url(URL).get().build()

        val response = client.newCall(request).execute()

        val responseBody = response.body()

        if(responseBody != null){
            val json = responseBody.string()
            Log.d("resposta ===" +json, "cuzinhopretoassado")
        }
    }




}