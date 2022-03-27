package com.pouchen.oauthdemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class Demo {
    @GetMapping("/hello")
    public String hello(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String,Object> loginInfo = ((Jwt)(auth.getPrincipal())).getClaims();
        return "hello " + loginInfo.get("name") + ", your pccuid is " + loginInfo.get("pccuid");
    }
}
