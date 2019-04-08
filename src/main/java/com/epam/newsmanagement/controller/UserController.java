package com.epam.newsmanagement.controller;

import com.epam.newsmanagement.dto.UserDTO;
import com.epam.newsmanagement.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Log4j
@Controller
@ControllerAdvice
public class UserController {
    private final static String REGISTRATION_URL = "registration";

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDTO());

        return REGISTRATION_URL;
    }

    @RequestMapping(value = "/registerAction", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return REGISTRATION_URL;
        }

        boolean success = userService.saveUser(userDTO);

        if (!success) {
            Boolean userExist = true;
            model.addAttribute("userExist", userExist);

            return REGISTRATION_URL;
        }

        return "login";
    }
}
