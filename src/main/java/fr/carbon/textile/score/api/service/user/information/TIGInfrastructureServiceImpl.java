package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.repository.user.information.TIGInfrastructureRepository;
import org.springframework.stereotype.Service;

@Service
public class TIGInfrastructureServiceImpl implements TIGInfrastructureService {
    private TIGInfrastructureRepository _tigInfrastructureRepository;

    public TIGInfrastructureServiceImpl(TIGInfrastructureRepository tigInfrastructureRepository) {
        super();
        _tigInfrastructureRepository = tigInfrastructureRepository;
    }
}
