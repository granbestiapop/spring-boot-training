package com.example.demo.controllers;

import com.example.demo.services.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/")
public class PingController {

    @Autowired
    PingService pingService;

    @GetMapping(path="/ping")
    public @ResponseBody String ping(){
        return pingService.getString();
    }

}
