package fr.carbon.textile.score.api.database.initialisation;

import fr.carbon.textile.score.api.database.entity.user.information.AuthorityEntity;
import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.security.PasswordEncoderBean;
import fr.carbon.textile.score.api.tmp_repository.AuthorityRepository;
import fr.carbon.textile.score.api.tmp_repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
public class PasswordInitialisation {
    private final UserRepository _userRepository;
    private final AuthorityRepository _authorityRepository;
    private final PasswordEncoder _bCryptPasswordEncoder;

    public PasswordInitialisation(
            UserRepository userRepository,
            PasswordEncoderBean passwordEncoderBean,
            AuthorityRepository authorityRepository
    ) {
        _userRepository = userRepository;
        _bCryptPasswordEncoder = passwordEncoderBean.getPasswordEncoder();
        _authorityRepository = authorityRepository;
        initiatePassword();
    }

    private AuthorityEntity getAuthorityEntity(@NotBlank String username) {
        Optional<UserEntity> user = _userRepository.queryByAuthorityUsername(username);
        if (user.isEmpty()) {
            throw new IllegalStateException("Username not found when initiating password : " + user);
        }
        return user.get().getAuthority();
    }

    private void setNewPassword(@NonNull AuthorityEntity toModify, @NotBlank String rawPassword) {
        toModify.setPassword(_bCryptPasswordEncoder.encode(rawPassword));
        _authorityRepository.save(toModify);
    }

    private void initiatePassword() {
        AuthorityEntity tanAuthority = getAuthorityEntity("TAN");
        setNewPassword(tanAuthority, "intensive-project-03-tan");
    }
}
