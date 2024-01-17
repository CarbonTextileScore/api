package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.service.user.information.TIGInfrastructureService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/tig-infrastructure")
public class TIGInfrastructureController {
    private TIGInfrastructureService _tigInfrastructureService;

    public TIGInfrastructureController(TIGInfrastructureService tigInfrastructureService) {
        _tigInfrastructureService = tigInfrastructureService;
    }
}
