package fr.carbon.textile.score.api.security.user.details;

import fr.carbon.textile.score.api.database.entity.user.information.AuthorityEntity;
import fr.carbon.textile.score.api.tmp_repository.AuthorityRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {
    private final AuthorityRepository _authorityRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(@NotBlank String username) throws UsernameNotFoundException {
        Optional<AuthorityEntity> authority = _authorityRepository.queryByUsername(username);

        if (authority.isEmpty()) {
            throw new UsernameNotFoundException("User not found, specified username : " + username);
        }

        return UserDetailsImplementation.build(authority.get());
    }
}
