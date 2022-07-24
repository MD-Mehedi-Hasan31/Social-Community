package com.sc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView helloWorld(){
        ModelAndView mv= new ModelAndView();
        mv.addObject("name", "Mehedi");
        mv.setViewName("hello");
        return mv;
    }
}
