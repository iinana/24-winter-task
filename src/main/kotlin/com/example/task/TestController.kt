package com.example.task

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class TestController() {
    @GetMapping
    fun getString() = "Hello World!"

    @PostMapping
    fun echoString() : String {
        println("Hello")
        return "Hello"
    }
}
