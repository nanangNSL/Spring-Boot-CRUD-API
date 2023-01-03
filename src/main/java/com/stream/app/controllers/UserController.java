package com.stream.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stream.app.models.entities.User;
import com.stream.app.services.UserService;

@RestController

public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/api/register")
    public User register(@RequestBody User user){
        return userService.createUser(user);
    }
    @PostMapping("/api/check-email")
  public String checkEmail(@RequestParam("email") String email) {
    if (userService.emailExists(email)) {
      return "success";
    } else {
      return "Not found";
    }
  }

  @PostMapping("/api/login")
  public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
    String token = userService.login(username, password);
    if (token != null) {
      return token;
    } else {
      return "Login gagal periksa kembali username dan password";
    }
}
}