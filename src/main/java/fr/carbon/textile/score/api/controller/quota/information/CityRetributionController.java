package fr.carbon.textile.score.api.controller.quota.information;

import fr.carbon.textile.score.api.service.quota.information.CityRetributionService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/city-retribution")
public class CityRetributionController {
    private CityRetributionService _cityRetributionService;

    public CityRetributionController(CityRetributionService cityRetributionService) {
        _cityRetributionService = cityRetributionService;
    }
}
