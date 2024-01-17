package fr.carbon.textile.score.api.mapper.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.AuthorityEntity;
import fr.carbon.textile.score.api.dto.user.information.AuthorityDTO;
import fr.carbon.textile.score.api.mapper.DTOEntityMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AuthorityMapper implements DTOEntityMapper<AuthorityDTO, AuthorityEntity> {
    private final RoleMapper _roleMapper;

    public AuthorityMapper(@Lazy RoleMapper roleMapper) {
        _roleMapper = roleMapper;
    }

    @Override
    public AuthorityDTO toDTO(AuthorityEntity entity) {
        return AuthorityDTO.builder()
                .id(entity.getId())
                .role(_roleMapper.toDTO(entity.getRole()))
                .username(entity.getUsername())
                .build();
    }

    @Override
    public AuthorityEntity toEntity(AuthorityDTO dto) {
        AuthorityEntity authorityEntity = new AuthorityEntity();
        authorityEntity.setRole(_roleMapper.toEntity(dto.getRole()));
        authorityEntity.setPassword(dto.getPassword());
        authorityEntity.setUsername(dto.getUsername());
        return authorityEntity;
    }
}
