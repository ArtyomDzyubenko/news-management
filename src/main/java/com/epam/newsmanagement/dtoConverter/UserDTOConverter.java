package com.epam.newsmanagement.dtoConverter;

import com.epam.newsmanagement.dto.UserDTO;
import com.epam.newsmanagement.entity.Authority;
import com.epam.newsmanagement.entity.User;
import java.util.HashSet;
import java.util.Set;

public class UserDTOConverter {
    public static UserDTO Entity2DTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public static User DTO2Entity(UserDTO dto) {
        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEnabled(true);

        Set<Authority> authoritySet = new HashSet<>();
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");
        authority.setUser(entity);
        authoritySet.add(authority);
        entity.setAuthorities(authoritySet);

        return entity;
    }
}
