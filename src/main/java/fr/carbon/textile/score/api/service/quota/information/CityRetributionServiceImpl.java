package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.repository.quota.information.CityRetributionRepository;
import org.springframework.stereotype.Service;

@Service
public class CityRetributionServiceImpl implements CityRetributionService {
    private CityRetributionRepository _cityRetributionRepository;

    public CityRetributionServiceImpl(CityRetributionRepository cityRetributionRepository) {
        super();
        _cityRetributionRepository = cityRetributionRepository;
    }
}
