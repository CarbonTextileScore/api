package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
}
