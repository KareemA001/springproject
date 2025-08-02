package com.example.springjourney.project.controller;

import com.example.springjourney.project.model.Contact;
import com.example.springjourney.project.service.ContactService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private static Logger log = LoggerFactory.getLogger(ContactController.class) ;
    ContactService contactService ;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService ;
    }
    @RequestMapping("/contact")
    public String contact(Model model){
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }
    /*
    @RequestMapping(value = "/saveMsg",method = POST)
    public ModelAndView saveMsg(@RequestParam String name,@RequestParam String mobileNum
                               ,@RequestParam String email,@RequestParam String subject
                               ,@RequestParam String message){
        log.info("Name "+name);
        log.info("MobileNumber "+mobileNum);
        log.info("Email "+email);
        log.info("subject "+subject);
        log.info("message "+message);

        return new ModelAndView("redirect:/contact") ;
    }
    */

    @PostMapping("/saveMsg")
    public String saveMsg(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to "+errors.toString());
            return "contact.html";
        }
        contactService.savemessageDetails(contact);
        return "redirect:/contact" ;
    }

}
