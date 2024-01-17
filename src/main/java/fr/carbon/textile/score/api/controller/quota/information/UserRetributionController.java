package fr.carbon.textile.score.api.controller.quota.information;

import fr.carbon.textile.score.api.service.quota.information.UserRetributionService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user-retribution")
public class UserRetributionController {
    private UserRetributionService _userRetributionService;

    public UserRetributionController(UserRetributionService userRetributionService) {
        _userRetributionService = userRetributionService;
    }
}
