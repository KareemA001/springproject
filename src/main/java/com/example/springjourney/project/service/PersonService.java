package com.example.springjourney.project.service;

import com.example.springjourney.project.constants.ProjectConstants;
import com.example.springjourney.project.model.Person;
import com.example.springjourney.project.model.Roles;
import com.example.springjourney.project.repos.PersonRepository;
import com.example.springjourney.project.repos.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(ProjectConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
