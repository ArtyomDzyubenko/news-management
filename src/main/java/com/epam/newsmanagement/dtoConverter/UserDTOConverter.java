package com.epam.newsmanagement.dtoConverter;

import com.epam.newsmanagement.dto.UserDTO;
import com.epam.newsmanagement.entity.Authority;
import com.epam.newsmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDTOConverter {

    @Autowired
    private static BCryptPasswordEncoder passwordEncoder;

    public static UserDTO Entity2DTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public static User DTO2Entity(UserDTO dto) {
        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setEnabled(true);

        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUser(entity);
        entity.setAuthority(authority);

        return entity;
    }
}
