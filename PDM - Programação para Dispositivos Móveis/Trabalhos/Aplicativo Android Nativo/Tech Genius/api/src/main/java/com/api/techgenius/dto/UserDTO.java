package com.api.techgenius.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    private String name;
    @NotNull
    private int score;
}
