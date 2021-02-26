package ru.hiber.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error_page")
    public String errorPage() {
        return "error_page";
    }

}
