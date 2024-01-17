package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.repository.quota.information.QuotaRepository;
import org.springframework.stereotype.Service;

@Service
public class QuotaServiceImpl implements QuotaService {
    private QuotaRepository _quotaRepository;

    public QuotaServiceImpl(QuotaRepository quotaRepository) {
        super();
        _quotaRepository = quotaRepository;
    }
}
