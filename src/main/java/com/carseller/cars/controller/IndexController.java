package com.carseller.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String goHome(){
        return "index";
    }
}
