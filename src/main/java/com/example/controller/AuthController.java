package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.services.UserMetier;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserMetier services;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = services.login(username, password);

        if (user != null) {

            session.setAttribute("user", user.getUsername());
            session.setAttribute("role", user.getRole());

            return "redirect:/produits/index";
        }

        model.addAttribute("error", "Invalid credentials");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}