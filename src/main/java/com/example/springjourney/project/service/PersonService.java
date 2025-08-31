package com.example.springjourney.project.service;

import com.example.springjourney.project.constants.ProjectConstants;
import com.example.springjourney.project.model.Person;
import com.example.springjourney.project.model.Roles;
import com.example.springjourney.project.repos.PersonRepository;
import com.example.springjourney.project.repos.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(ProjectConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }
}
