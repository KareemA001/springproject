package com.example.springjourney.project.repos;

import com.example.springjourney.project.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {

    Roles getByRoleName(String roleName);
}
