package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dto.UserDTO;

public interface UserService {
    boolean saveUser(UserDTO user);
}
