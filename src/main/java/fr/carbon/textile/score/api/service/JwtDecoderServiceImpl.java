package fr.carbon.textile.score.api.service;

import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.security.jwt.JwtUtils;
import fr.carbon.textile.score.api.tmp_repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class JwtDecoderServiceImpl implements JwtDecoderService {
    private final JwtUtils _jwtUtils;
    private final UserRepository _userRepository;
    private final HttpServletRequest _httpServletRequest;

    public JwtDecoderServiceImpl(
            JwtUtils jwtUtils, UserRepository userRepository, HttpServletRequest httpServletRequest
    ) {
        _jwtUtils = jwtUtils;
        _userRepository = userRepository;
        _httpServletRequest = httpServletRequest;
    }

    @Override
    public UserEntity recoverUserOfThisRequest() {
        String token = _jwtUtils.parseJwt(_httpServletRequest);
        String username = _jwtUtils.getUsernameFromJwtToken(token);
        Optional<UserEntity> user = _userRepository.queryByAuthorityUsername(username);
        if (user.isEmpty()) {
            throw new RuntimeException("Token could not be properly parsed during User Entity recovery");
        }
        return user.get();
    }
}
