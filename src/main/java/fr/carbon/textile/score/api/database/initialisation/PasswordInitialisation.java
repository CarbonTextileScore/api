package fr.carbon.textile.score.api.database.initialisation;

import fr.carbon.textile.score.api.database.entity.user.information.AuthorityEntity;
import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.repository.user.information.AuthorityRepository;
import fr.carbon.textile.score.api.repository.user.information.UserRepository;
import fr.carbon.textile.score.api.security.PasswordEncoderBean;
import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Configuration
public class PasswordInitialisation {
    private final UserRepository _userRepository;
    private final AuthorityRepository _authorityRepository;
    private final PasswordEncoder _bCryptPasswordEncoder;
    private final Map<String, String> _usernamePassword;

    public PasswordInitialisation(
            UserRepository userRepository,
            PasswordEncoderBean passwordEncoderBean,
            AuthorityRepository authorityRepository
    ) {
        _userRepository = userRepository;
        _bCryptPasswordEncoder = passwordEncoderBean.getPasswordEncoder();
        _authorityRepository = authorityRepository;
        _usernamePassword = new HashMap<>();
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

    private void initiateUsernamePasswordMap() {
        _usernamePassword.put("TAN", "intensive-project-03-tan");
        _usernamePassword.put("VAL", "intensive-project-03-val");
        _usernamePassword.put("ANGELINA", "intensive-project-03-angelina");
        _usernamePassword.put("CHRISTELLE", "intensive-project-03-christelle");
        _usernamePassword.put("RANDOM", "intensive-project-03-random");
        _usernamePassword.put("MAYOR-CAEN", "intensive-project-03-mayor-caen");
        _usernamePassword.put("PRESIDENT-FRANCE", "intensive-project-03-president-france");
    }

    private void initiatePassword() {
        initiateUsernamePasswordMap();
        for (Map.Entry<String, String> entry : _usernamePassword.entrySet()) {
            AuthorityEntity authority = getAuthorityEntity(entry.getKey());
            setNewPassword(authority, entry.getValue());
        }
    }
}
