package com.example.springjourney.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BasicEntity {

    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    @Column(name="updated_by")
    private String updatedBy;

}
