package com.epam.newsmanagement.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTO {

    @NotNull(message = "{app.error.empty}")
    @NotBlank(message = "{app.error.empty}")
    @Size(min = 3, max = 20, message = "{app.error.user.username}")
    private String username;

    @NotNull(message = "{app.error.empty}")
    @NotBlank(message = "{app.error.empty}")
    @Size(min = 8, max = 20, message = "{app.error.user.password}")
    private String password;

    public UserDTO() {}

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
