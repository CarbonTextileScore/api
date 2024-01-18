package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.dto.quota.information.CityRetributionDTO;
import fr.carbon.textile.score.api.repository.quota.information.CityRetributionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityRetributionServiceImpl implements CityRetributionService {
    private CityRetributionRepository _cityRetributionRepository;

    public CityRetributionServiceImpl(CityRetributionRepository cityRetributionRepository) {
        super();
        _cityRetributionRepository = cityRetributionRepository;
    }

    @Override
    public List<CityRetributionDTO> getAppliedRetributions(Double triggerPercentage) {
        return _cityRetributionRepository.findBy_triggerPercentageLessThanEqual(triggerPercentage.intValue()).stream()
                .map(cityRetributionEntity -> CityRetributionDTO.builder()
                        .retribution(cityRetributionEntity.getRetribution())
                        .build()
                ).toList();
    }

    @Override
    public List<CityRetributionDTO> getIncomingRetributions(Double triggerPercentage) {
        return _cityRetributionRepository.findBy_triggerPercentageGreaterThan(triggerPercentage.intValue()).stream()
                .map(cityRetributionEntity -> CityRetributionDTO.builder()
                        .retribution(cityRetributionEntity.getRetribution())
                        .build()
                ).toList();
    }
}
