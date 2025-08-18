package com.example.springjourney.project.service;

import com.example.springjourney.project.constants.ProjectConstants;
import com.example.springjourney.project.model.Contact;
import com.example.springjourney.project.repos.ContactRepo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    @PostMapping(value="/saveMsg")
    public boolean saveMessageDetails(@Valid @ModelAttribute("contact") Contact contact) {

        boolean isSaved = false;
        contact.setStatus(ProjectConstants.OPEN);
        contact.setCreatedBy(ProjectConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepo.saveContactMsg(contact);
        if (result > 0) {
            isSaved = true;
        }
        return isSaved;
    }
    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepo.findMsgsWithStatus(ProjectConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepo.updateMsgStatus(contactId,ProjectConstants.CLOSE, updatedBy);
        if(result>0) {
            isUpdated = true;
        }
        return isUpdated;
    }

}
