package com.hexagonal.tasks.infrastructure.entities;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.hexagonal.tasks.domain.models.Task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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

    @Column(name = "creation_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP"/*, insertable = false, updatable = false*/)
    //@Transient//NO SE CONSIDERA PARA LA CAPTURA DE DATOS
    private LocalDateTime creationDate;

    @Column(name = "completed", columnDefinition = "TINYINT(1) NOT NULL")
    private boolean completed;

    @PrePersist
    public void prePersist() {
        // Si creationDate no tiene valor, asignamos la fecha y hora actuales
        if (creationDate == null) {
            creationDate = LocalDateTime.now(ZoneId.of("America/Mexico_City"));
        }
    }
    
    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(task.getId(), task.getTitle(), task.getDescription(), task.getCreationDate(), task.isCompleted());
    }

    public Task toDomainModel(){
        return new Task(id, title, description, creationDate, completed);
    }
}
