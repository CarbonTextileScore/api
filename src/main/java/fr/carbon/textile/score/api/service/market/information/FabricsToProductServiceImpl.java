package fr.carbon.textile.score.api.service.market.information;

import fr.carbon.textile.score.api.repository.market.information.FabricToProductRepository;
import org.springframework.stereotype.Service;

@Service
public class FabricsToProductServiceImpl implements FabricsToProductService {
    private FabricToProductRepository _fabricToProductRepository;

    public FabricsToProductServiceImpl(FabricToProductRepository fabricToProductRepository) {
        super();
        _fabricToProductRepository = fabricToProductRepository;
    }
}
