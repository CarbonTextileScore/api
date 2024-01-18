package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.dto.quota.information.CityRetributionDTO;

import java.util.List;

public interface CityRetributionService {
    List<CityRetributionDTO> getAppliedRetributions(Double triggerPercentage);

    List<CityRetributionDTO> getIncomingRetributions(Double triggerPercentage);
}
