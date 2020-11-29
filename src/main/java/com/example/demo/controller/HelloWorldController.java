package com.example.demo.controller;

import com.example.demo.dto.HelloRequest;
import com.example.demo.dto.HelloResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HelloWorldController {

    @PostMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HelloResponse helloWorldController(@RequestBody HelloRequest request) {
        HelloResponse response;

        if (request.getMessage().equals("Dima")) {
            response = new HelloResponse("Dima - noob!");
        } else if (request.getMessage().equals("Masha")) {
            response = new HelloResponse("Masha - true programmer!");
        } else response = new HelloResponse("Feed the cat");

        return response;
    }
}
