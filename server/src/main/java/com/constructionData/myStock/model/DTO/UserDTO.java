package com.constructionData.myStock.model.DTO;

import lombok.Builder;

public record UserDTO(String username, String password, String email) {
    @Builder
    public UserDTO {
    }
}

