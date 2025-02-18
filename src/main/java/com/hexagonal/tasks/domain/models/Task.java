package com.hexagonal.tasks.domain.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;
}
