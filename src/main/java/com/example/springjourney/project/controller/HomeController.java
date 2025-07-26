package com.example.springjourney.project.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"","/","/home"})
    public String homePage(Model model){
        model.addAttribute("username", "Kareem Alaa");;
        return "home.html";
    }
}
