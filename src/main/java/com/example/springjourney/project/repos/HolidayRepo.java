package com.example.springjourney.project.repos;

import com.example.springjourney.project.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidayRepo {

    private final JdbcTemplate jdbcTamplate ;

    @Autowired
    public HolidayRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTamplate = jdbcTemplate;
    }

    public List<Holiday> findAllHolidays(){
        String sql = "select * from holidays";
        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
        return this.jdbcTamplate.query(sql,rowMapper);
    }
}
