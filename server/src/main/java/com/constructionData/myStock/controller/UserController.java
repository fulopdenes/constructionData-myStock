package com.constructionData.myStock.controller;

import com.constructionData.myStock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    POST /users
//    GET /users/{id}
//    PUT /users/{id}
//    DELETE /users/{id}

}
