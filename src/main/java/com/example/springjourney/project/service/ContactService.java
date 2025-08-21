package com.example.springjourney.project.service;

import com.example.springjourney.project.constants.ProjectConstants;
import com.example.springjourney.project.model.Contact;
import com.example.springjourney.project.repos.ContactRepo;
import com.example.springjourney.project.repos.ContactRepository;
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
    private ContactRepository contactRepository;

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(ProjectConstants.OPEN);
        contact.setCreatedBy(ProjectConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        Contact result = contactRepository.save(contact);
        if(result != null && result.getContactId() > 0){
            isSaved = true;
        }
        return isSaved;
    }
    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(ProjectConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isChanged = false;
        Contact isUpdated = contactRepository.findById(contactId).orElse(null);
        if(isUpdated != null){
            isUpdated.setStatus(ProjectConstants.CLOSE);
            isUpdated.setUpdatedBy(updatedBy);
            isUpdated.setUpdatedAt(LocalDateTime.now());
        }
        Contact isUpdated2 = contactRepository.save(isUpdated);
        if(isUpdated2 != null && isUpdated2.getUpdatedBy() != null){
            isChanged = true;
        }
        return isChanged;
    }
}
