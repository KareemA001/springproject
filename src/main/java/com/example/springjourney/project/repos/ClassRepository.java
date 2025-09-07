package com.example.springjourney.project.repos;

import com.example.springjourney.project.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<EazyClass, Integer> {

}
