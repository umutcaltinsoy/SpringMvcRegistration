package com.innova.controller;

import com.innova.dto.UserValidationDto;
import com.innova.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // http://localhost:3030/register
    @GetMapping("/register")
    public String register(@ModelAttribute UserValidationDto dto, Model model) {
        model.addAttribute("dto", dto);
        return "register";
    }

    // http://localhost:3030/register
    @PostMapping("/register")
    public String save(@Valid @ModelAttribute(name = "dto") UserValidationDto dto,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("Error");
            return "register";
        } else {
            log.info("User : " + dto.toString());
            userService.saveUser(dto);
            log.info(dto);
        }
        return "redirect:/login";
    }


}
