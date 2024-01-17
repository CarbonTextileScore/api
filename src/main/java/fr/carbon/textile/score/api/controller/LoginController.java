package fr.carbon.textile.score.api.controller;

import fr.carbon.textile.score.api.security.jwt.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationManager _authenticationManager;
    private final JwtUtils _jwtUtils;

    public LoginController(
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils
    ) {
        _authenticationManager = authenticationManager;
        _jwtUtils = jwtUtils;
    }

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid LoginPayload userData) {
        Authentication authentication = _authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userData.getUsername(), userData.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = _jwtUtils.generateJwtToken(authentication);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwt);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }
}
