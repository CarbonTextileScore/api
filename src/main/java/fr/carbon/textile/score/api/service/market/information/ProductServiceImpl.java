package fr.carbon.textile.score.api.service.market.information;

import fr.carbon.textile.score.api.repository.market.information.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository _productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        _productRepository = productRepository;
    }
}
