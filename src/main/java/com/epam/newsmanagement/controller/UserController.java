package com.epam.newsmanagement.controller;

import com.epam.newsmanagement.dto.UserDTO;
import com.epam.newsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterFrom(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);

        return "registration";
    }

    @RequestMapping(value = "/registerAction", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody UserDTO user) {
        boolean success = userService.saveUser(user);

        if (!success) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
