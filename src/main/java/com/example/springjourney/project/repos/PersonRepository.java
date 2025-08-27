package com.example.springjourney.project.repos;

import com.example.springjourney.project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person readByEmail(String email);
}
