package fr.carbon.textile.score.api.service.market.information;

import fr.carbon.textile.score.api.repository.market.information.FabricRepository;
import org.springframework.stereotype.Service;

@Service
public class FabricServiceImpl implements FabricService {
    private FabricRepository _fabricRepository;

    public FabricServiceImpl(FabricRepository fabricRepository) {
        super();
        _fabricRepository = fabricRepository;
    }
}
