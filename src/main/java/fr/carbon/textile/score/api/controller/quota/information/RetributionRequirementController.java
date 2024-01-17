package fr.carbon.textile.score.api.controller.quota.information;

import fr.carbon.textile.score.api.service.quota.information.RetributionRequirementService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/punishment-requirement")
public class RetributionRequirementController {
    private RetributionRequirementService _retributionRequirementService;

    public RetributionRequirementController(RetributionRequirementService retributionRequirementService) {
        _retributionRequirementService = retributionRequirementService;
    }
}
