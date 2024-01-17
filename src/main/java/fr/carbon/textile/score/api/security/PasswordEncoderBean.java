package fr.carbon.textile.score.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderBean {
    private final PasswordEncoder _passwordEncoder;

    public PasswordEncoderBean() {
        _passwordEncoder = new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return _passwordEncoder;
    }
}
