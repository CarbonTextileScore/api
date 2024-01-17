package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.repository.quota.information.UserRetributionRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRetributionServiceImpl implements UserRetributionService {
    private UserRetributionRepository _userRetributionRepository;

    public UserRetributionServiceImpl(UserRetributionRepository userRetributionRepository) {
        super();
        _userRetributionRepository = userRetributionRepository;
    }
}
