package com.example.springjourney.project.repos;

import com.example.springjourney.project.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday,String> {
}
