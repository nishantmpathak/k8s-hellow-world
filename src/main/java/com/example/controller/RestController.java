package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/hello-world")
public class RestController {

    @GetMapping
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World");
    }

}
