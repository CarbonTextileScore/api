package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.service.user.information.FamilyService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/family")
public class FamilyController {
    private FamilyService _familyService;

    public FamilyController(FamilyService familyService) {
        _familyService = familyService;
    }
}
