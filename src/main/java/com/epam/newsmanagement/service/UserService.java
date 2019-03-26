package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dto.UserDTO;

public interface UserService {
    UserDTO findUserByUsername(String username);
    boolean saveUser(UserDTO user);
}
