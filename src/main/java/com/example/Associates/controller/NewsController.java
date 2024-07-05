package com.example.Associates.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {

    @GetMapping
    public ResponseEntity<String> newsIndex() {
        return ResponseEntity.ok("News index | =D");
    }

}
