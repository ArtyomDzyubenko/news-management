package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dao.UserDAO;
import com.epam.newsmanagement.dto.UserDTO;
import com.epam.newsmanagement.dtoConverter.UserDTOConverter;
import com.epam.newsmanagement.entity.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDTO findUserByUsername(String username) {
        return UserDTOConverter.Entity2DTO(userDAO.findUserByUsername(username));
    }

    @Override
    public boolean saveUser(UserDTO user) {
        User exist = userDAO.findUserByUsername(user.getUsername());
        User entity = UserDTOConverter.DTO2Entity(user);

        if (exist != null) {
            return false;
        } else {
            userDAO.saveUser(entity);

            return true;
        }
    }
}
