package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.dto.user.information.AuthorityDTO;
import fr.carbon.textile.score.api.mapper.user.information.AuthorityMapper;
import fr.carbon.textile.score.api.repository.user.information.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    private AuthorityRepository _authorityRepository;

    private AuthorityMapper _authorityMapper;

    public AuthorityServiceImpl(AuthorityRepository authorityRepository, AuthorityMapper authorityMapper) {
        super();
        _authorityRepository = authorityRepository;
        _authorityMapper = authorityMapper;
    }

    @Override
    public void createAuthority(AuthorityDTO authorityDTO) {
        _authorityRepository.save(_authorityMapper.toEntity(authorityDTO));
    }
}
