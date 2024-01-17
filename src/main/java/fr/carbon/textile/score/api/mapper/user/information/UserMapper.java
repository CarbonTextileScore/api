package fr.carbon.textile.score.api.mapper.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.mapper.DTOEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DTOEntityMapper<UserDTO, UserEntity> {
    @Override
    public UserDTO toDTO(UserEntity entity) {
        return UserDTO.builder()
                .name(entity.getName())
                .lastname(entity.getLastname())
                .build();
    }

    @Override
    public UserEntity toEntity(UserDTO dto) {
        return null;
    }
}
