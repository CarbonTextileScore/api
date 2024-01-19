package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.dto.quota.information.UserRetributionDTO;

import java.util.List;

public interface UserRetributionService {
    List<UserRetributionDTO> getUserRetributions();
}
