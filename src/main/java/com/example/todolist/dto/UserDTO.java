package com.example.todolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    // Include other fields relevant for the client, but exclude sensitive ones

    // Constructors, Getters, and Setters
    public UserDTO() {}

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
