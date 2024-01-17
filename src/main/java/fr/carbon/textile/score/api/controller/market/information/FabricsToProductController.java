package fr.carbon.textile.score.api.controller.market.information;

import fr.carbon.textile.score.api.service.market.information.FabricsToProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/fabrics-to-product")
public class FabricsToProductController {
    private FabricsToProductService _fabricsToProductService;

    public FabricsToProductController(FabricsToProductService fabricsToProductService) {
        _fabricsToProductService = fabricsToProductService;
    }
}
