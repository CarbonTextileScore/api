package fr.carbon.textile.score.api.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginPayload {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
