package com.epam.newsmanagement.controller;

import com.epam.newsmanagement.dto.UserDTO;
import com.epam.newsmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
@ControllerAdvice
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDTO());

        return "registration";
    }

    @RequestMapping(value = "/registerAction", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        boolean success = userService.saveUser(userDTO);

        if (!success) {
            Boolean userExist = true;
            model.addAttribute("userExist", userExist);

            return "registration";
        }

        return "login";
    }
}
