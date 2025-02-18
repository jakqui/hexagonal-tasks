package com.hexagonal.tasks.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexagonal.tasks.application.services.TaskService;
import com.hexagonal.tasks.application.usecases.CreateTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecases.DeleteTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecases.RetrieveTaskUseCaseImpl;
import com.hexagonal.tasks.application.usecases.UpdateTaskUseCaseImpl;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.out.TaskRepositoryPort;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
            new CreateTaskUseCaseImpl(taskRepositoryPort), 
            new RetrieveTaskUseCaseImpl(taskRepositoryPort),
            new UpdateTaskUseCaseImpl(taskRepositoryPort),
            new DeleteTaskUseCaseImpl(taskRepositoryPort),
            getAdditionalTaskInfoUseCase 
            );
    }
}
