package ru.geekbrains.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/home")
    public String hello(Model uiModel) {
        return "home";
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

}
