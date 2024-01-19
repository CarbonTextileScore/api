package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.dto.quota.information.UserRetributionDTO;
import fr.carbon.textile.score.api.repository.quota.information.UserRetributionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRetributionServiceImpl implements UserRetributionService {
    private UserRetributionRepository _userRetributionRepository;

    public UserRetributionServiceImpl(UserRetributionRepository userRetributionRepository) {
        super();
        _userRetributionRepository = userRetributionRepository;
    }

    @Override
    public List<UserRetributionDTO> getUserRetributions() {
        return _userRetributionRepository.findAll()
                .stream()
                .map(u -> UserRetributionDTO.builder()
                        .id(u.getId())
                        .label(u.getRetribution())
                        .quota(u.getQuotaGains())
                        .build()
                ).toList();
    }
}
