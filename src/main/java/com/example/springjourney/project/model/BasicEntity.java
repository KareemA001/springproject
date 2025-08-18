package com.example.springjourney.project.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BasicEntity {

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
