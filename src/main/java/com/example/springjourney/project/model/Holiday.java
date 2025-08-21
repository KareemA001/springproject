package com.example.springjourney.project.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="holidays")
@Entity
public class Holiday extends BasicEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="day")
    public String day ;
    public String reason ;
    @Enumerated(EnumType.STRING)
    public Type type ;

    public enum Type {
        FESTIVAL, FEDERAL
    } ;
    /*
    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public String getReason() {
        return reason;
    }

    public Type getType() {
        return type;
    }
    */

}
