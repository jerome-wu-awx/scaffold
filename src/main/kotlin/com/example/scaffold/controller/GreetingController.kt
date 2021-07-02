package com.example.scaffold.controller

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class GreetingController(
    @Value("\${name}")
    private val name : String,

    @Value("\${target.host}")
    private val host : String,

    @Value("\${target.port}")
    private val port : String
) {
    @GetMapping("/greeting")
    fun getGreeting() : String{

        if (host == "") {
            return "Hello, Im " + name + ".";
        }
        val okHttpClient = OkHttpClient()
        val url = "http://" + host + ":" + port + "/greeting";
        val request: Request = Request.Builder().url(url).build()
        var bodyString = ""
        okHttpClient.newCall(request).execute().use { response ->
            val body: ResponseBody? = response.body()
            if (body != null)
                bodyString = body.string()
            println(bodyString)
        }
        return "Hello, Im " + name + ". " + bodyString;
    }
}