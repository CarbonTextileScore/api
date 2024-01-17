package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.repository.quota.information.RetributionRequirementRepository;
import org.springframework.stereotype.Service;

@Service
public class RetributionRequirementServiceImpl implements RetributionRequirementService {
    private RetributionRequirementRepository _retributionRequirementRepository;

    public RetributionRequirementServiceImpl(RetributionRequirementRepository retributionRequirementRepository) {
        super();
        _retributionRequirementRepository = retributionRequirementRepository;
    }
}
