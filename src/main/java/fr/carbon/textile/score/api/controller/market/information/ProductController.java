package fr.carbon.textile.score.api.controller.market.information;

import fr.carbon.textile.score.api.dto.market.information.ProductDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.service.market.information.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService _productService;

    public ProductController(ProductService productService) {
        _productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_CITY')")
    public List<ProductDTO> getAll() throws CustomException {
        return _productService.getAllProducts();
    }
}
