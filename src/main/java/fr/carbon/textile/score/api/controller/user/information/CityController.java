package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.service.user.information.CityService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/city")
public class CityController {
    private CityService _cityService;

    public CityController(CityService cityService) {
        _cityService = cityService;
    }
}
