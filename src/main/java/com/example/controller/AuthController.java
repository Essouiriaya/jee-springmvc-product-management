package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.services.UserMetier;

@Controller
public class AuthController {
	
	@Autowired
    UserMetier services;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage() {
        return "login"; // login.jsp
    }

    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        User user = services.login(username, password);

        if (user != null) {

            session.setAttribute("user", user.getUsername());
            session.setAttribute("role", user.getRole());

            return "redirect:/index";

        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
