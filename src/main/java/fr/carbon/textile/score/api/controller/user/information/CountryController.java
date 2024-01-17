package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.service.user.information.CountryService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/country")
public class CountryController {
    private CountryService _countryService;

    public CountryController(CountryService countryService) {
        _countryService = countryService;
    }
}
