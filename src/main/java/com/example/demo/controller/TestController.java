package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
@CrossOrigin
public class TestController {

    @GetMapping(path = "/get-my-text")
    public void getMyText()
    {
        String text = "This is my first spring boot project.";
        System.out.println(text);
    }

    @GetMapping(path = "get-my-text1")
    public String getMyText1()
    {
        String myText = "This is my first spring boot project.";
        return myText;
    }
}
