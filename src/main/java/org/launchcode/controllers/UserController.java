package org.launchcode.controllers;


import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add")
    public String add(Model model) {
        model.addAttribute("title", "User Signup");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid @ModelAttribute User user, Errors errors, String verify){
        if (verify.equals(user.getPassword()) && errors.hasErrors()==false) {
            model.addAttribute("user", user);
            return "user/index";
        }
        else{
            model.addAttribute("title", "User Signup");
            model.addAttribute("message", "Passwords do not match");
            return "user/add";
        }
    }

}
