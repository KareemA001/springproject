package com.example.springjourney.project.service;

import com.example.springjourney.project.controller.ContactController;
import com.example.springjourney.project.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactService.class) ;

    public boolean savemessageDetails(Contact contact){
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }

}
