package com.example.studyolle.account;

import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.Normalizer;

@Controller
public class AccountController {
    @GetMapping("/sign-up")
    public String signUpForm(Model model){
        return "account/sign-up";
    }
}
