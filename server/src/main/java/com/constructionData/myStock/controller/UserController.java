package com.constructionData.myStock.controller;

import com.constructionData.myStock.model.DTO.UserDTO;
import com.constructionData.myStock.model.user.AppUser;
import com.constructionData.myStock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<AppUser> createUser(@RequestBody UserDTO newUser) {
        AppUser createdUser = userService.createUser(newUser);
        // TODO: if product parameters are not proper, then should inform the client what parameters are
        //  missing or obligatory.
        if (createdUser != null) {
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
