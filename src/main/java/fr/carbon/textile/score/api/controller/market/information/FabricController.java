package fr.carbon.textile.score.api.controller.market.information;

import fr.carbon.textile.score.api.service.market.information.FabricService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/fabric")
public class FabricController {
    private FabricService _fabricService;

    public FabricController(FabricService fabricService) {
        super();
        _fabricService = fabricService;
    }
}
