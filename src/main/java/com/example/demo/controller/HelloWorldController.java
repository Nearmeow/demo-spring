package com.example.demo.controller;

import com.example.demo.dto.HelloRequest;
import com.example.demo.dto.HelloResponse;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    private HelloService helloService;

    @Autowired
    public HelloWorldController(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HelloResponse helloWorldController(@RequestBody HelloRequest request) {
        return helloService.saySomething(request);
    }
}
