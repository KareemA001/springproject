package com.example.springjourney.project.controller;


import com.example.springjourney.project.model.Profile;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class ProfileController {

    @RequestMapping(path="displayProfile")
    public ModelAndView displayProfile(Model model){
        Profile profile = new Profile();
        ModelAndView modelAndView = new ModelAndView("profile.html");
        model.addAttribute("profile", profile);
        return modelAndView;
    }
}
