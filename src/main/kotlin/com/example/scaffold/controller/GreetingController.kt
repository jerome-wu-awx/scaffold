package com.example.scaffold.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(
    @Value("\${name}")
    private val name : String,

    @Value("\${host}")
    private val host : String,

    @Value("\${port}")
    private val port : String
) {
    @GetMapping("/greeting")
    fun getGreeting() : String{
        return "hello, Im" + name;
    }
}