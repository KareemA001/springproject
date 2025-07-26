package com.example.springjourney.project.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"","/","/home"})
    public String homePage(){
        return "home.html";
    }
    /*
    @RequestMapping("/courses")         //Building a controller method for the courses page
    public String coursesPage(){        // but as it alway display the same content, i tried a second method
        return "courses.html" ;         // which is override addViewControllers method.
    }
    */

    /*
    @RequestMapping("/about")           //Building a controller method for the courses page
    public String aboutUsPage(){        // but as it alway display the same content, i tried a second method
        return "about.html" ;           // which is override addViewControllers method.
    }
    */

}
