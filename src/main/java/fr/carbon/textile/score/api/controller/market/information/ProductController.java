package fr.carbon.textile.score.api.controller.market.information;

import fr.carbon.textile.score.api.service.market.information.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class ProductController {
    private ProductService _productService;

    public ProductController(ProductService productService) {
        _productService = productService;
    }
}
