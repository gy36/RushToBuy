package com.example.controller;
 
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
/**
 * Created by YanMing on 2017/2/24.
 */
 
@Controller
public class HomeController {
   
 
    @RequestMapping("/hello")
    public String hello(){

        return "list";
    }
}