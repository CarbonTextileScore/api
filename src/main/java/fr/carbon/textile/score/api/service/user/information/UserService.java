package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

    UserDTO getUserIdentity(UserDTO userEntity);

    UserDTO getQuotaPersonal(UserDTO userEntity) throws CustomException;

    UserDTO getDashboard(UserDTO userDTO) throws CustomException;
}
