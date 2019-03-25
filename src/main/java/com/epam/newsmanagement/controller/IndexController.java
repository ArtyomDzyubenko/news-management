package com.epam.newsmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndexPage(Model model, Principal principal) {
        model.addAttribute("who", principal.getName());

        return "news";
    }
}
