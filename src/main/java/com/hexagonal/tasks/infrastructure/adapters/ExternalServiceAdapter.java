package com.hexagonal.tasks.infrastructure.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;

import lombok.Data;

public class ExternalServiceAdapter implements ExternalServicePort{
    //  https://jsonplaceholder.typicode.com/todos/
    //  https://jsonplaceholder.typicode.com/users/

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(){
        restTemplate = new RestTemplate();
    }

    //PETICIONES HTTP
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiURL = "https://jsonplaceholder.typicode.com/todos/"+taskId;
        ResponseEntity<JsonPlaceHolderTodo> response =  restTemplate.getForEntity(apiURL, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();
        if(todo == null){
            return null;
        }

        apiURL = "ttps://jsonplaceholder.typicode.com/users/"+ todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> responseUser =  restTemplate.getForEntity(apiURL, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = responseUser.getBody();
        if(user == null){
            return null;
        }
        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
        
    }

    @Data
    private static class JsonPlaceHolderTodo{
        private Long id;
        private Long userId;
    }

    @Data
    private static class JsonPlaceHolderUser{
        private Long id;
        private String name;
        private String email;
    }
}
