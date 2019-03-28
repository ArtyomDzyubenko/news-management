package com.epam.newsmanagement.dto;

import org.springframework.stereotype.Component;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class UserDTO {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;

    public UserDTO() {

    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
