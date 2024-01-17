package fr.carbon.textile.score.api.mapper.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.RoleEntity;
import fr.carbon.textile.score.api.dto.user.information.RoleDTO;
import fr.carbon.textile.score.api.mapper.DTOEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements DTOEntityMapper<RoleDTO, RoleEntity> {
    @Override
    public RoleDTO toDTO(RoleEntity entity) {
        return RoleDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public RoleEntity toEntity(RoleDTO dto) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(dto.getId());
        roleEntity.setName(dto.getName());
        return roleEntity;
    }
}
