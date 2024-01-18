package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();

    UserDTO getUserIdentity(UserEntity userEntity);

    UserDTO getQuotaPersonal(UserEntity userEntity) throws CustomException;
}
