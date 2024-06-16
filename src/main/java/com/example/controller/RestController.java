package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/hello-world")
public class RestController {

    @Value("${my.custom.property}")
    private String value;
    @GetMapping
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.status(HttpStatus.OK).body("Hi, Hello World "+value);
    }

}
