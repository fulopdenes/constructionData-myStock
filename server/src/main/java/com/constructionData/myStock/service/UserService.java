package com.constructionData.myStock.service;

import com.constructionData.myStock.model.DTO.UserDTO;
import com.constructionData.myStock.model.user.AppUser;
import com.constructionData.myStock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser createUser(UserDTO newUser) {

        AppUser createNewUser = AppUser.builder()
                .email(newUser.email())
                .username(newUser.username())
                .password(newUser.password())
                .build();

        return userRepository.save(createNewUser);

    }
}
