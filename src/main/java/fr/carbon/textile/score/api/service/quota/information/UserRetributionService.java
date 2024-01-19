package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.dto.quota.information.UserRetributionDTO;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;

import java.util.List;

public interface UserRetributionService {
    List<UserRetributionDTO> getUserRetributions(UserDTO userDTO) throws CustomException;
}
