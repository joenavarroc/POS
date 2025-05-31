package com.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    // Maneja cualquier error y redirige a error.html
    @RequestMapping("/error")  
    public String handleError() {
        return "error";  // Devuelve la vista "error.html"
    }
}

