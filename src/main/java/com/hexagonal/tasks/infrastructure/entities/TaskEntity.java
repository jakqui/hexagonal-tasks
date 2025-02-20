package com.hexagonal.tasks.infrastructure.entities;

import java.time.LocalDateTime;

import com.hexagonal.tasks.domain.models.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task")//CAMBIAR NOMBRE DE LA TABLA EN BD
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;

    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.isCompleted());
    }

    public Task toDomainModel(){
        return new Task(id, title, description, creationDate, completed);
    }
}
