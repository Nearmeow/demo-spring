package com.example.demo.service;

import com.example.demo.dto.HelloRequest;
import com.example.demo.dto.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloResponse saySomething(HelloRequest request) {
        HelloResponse response;

        if (request.getMessage().equals("Dima")) {
            response = new HelloResponse("Dima - noob!");
        } else if (request.getMessage().equals("Masha")) {
            response = new HelloResponse("Masha - true programmer!");
        } else {
            response = new HelloResponse("Feed the cat");
        }

        return response;
    }
}
