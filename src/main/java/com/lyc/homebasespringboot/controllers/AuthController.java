package com.lyc.homebasespringboot.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lyc.homebasespringboot.models.User;
import com.lyc.homebasespringboot.services.UserService;
import com.lyc.homebasespringboot.utilities.GsonPasswordExclusionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UserService service;

    @Autowired
    PasswordEncoder encoder;

    // Customized gson filter to remove password information in REST response
    static Gson gson = new GsonBuilder()
            .addSerializationExclusionStrategy(new GsonPasswordExclusionStrategy())
            .create();

    @PostMapping("/register")
    public String registerNewUser(@RequestBody User newUser){
        // Encrypt password and enable the new account
        String cipherPassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(cipherPassword);
        newUser.setAccountNonExpired(true);
        newUser.setAccountNonLocked(true);
        newUser.setCredentialsNonExpired(true);
        newUser.setEnabled(true);
        return gson.toJson(service.registerNewUser(newUser));
    }

}
