package com.epam.newsmanagement.dtoConverter;

import com.epam.newsmanagement.dto.UserDTO;
import com.epam.newsmanagement.entity.Authority;
import com.epam.newsmanagement.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDTOConverter {
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
