package fr.carbon.textile.score.api.service.quota.information;

import fr.carbon.textile.score.api.database.entity.user.information.TIGInfrastructureEntity;
import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.quota.information.UserRetributionDTO;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.repository.quota.information.UserRetributionRepository;
import fr.carbon.textile.score.api.repository.user.information.TIGInfrastructureRepository;
import fr.carbon.textile.score.api.repository.user.information.UserRepository;
import fr.carbon.textile.score.api.service.user.information.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRetributionServiceImpl implements UserRetributionService {
    private UserRetributionRepository _userRetributionRepository;

    private UserRepository _userRepository;

    private TIGInfrastructureRepository _tigInfrastructureRepository;

    public UserRetributionServiceImpl(UserRetributionRepository userRetributionRepository, UserRepository userRepository, TIGInfrastructureRepository tigInfrastructureRepository) {
        super();
        _userRetributionRepository = userRetributionRepository;
        _userRepository = userRepository;
        _tigInfrastructureRepository = tigInfrastructureRepository;
    }

    @Override
    public List<UserRetributionDTO> getUserRetributions(UserDTO userDTO) throws CustomException {
        UserEntity userEntity = _userRepository.findById(userDTO.getId()).orElseThrow(() -> new CustomException("User not found"));
        TIGInfrastructureEntity tigInfrastructureEntity = _tigInfrastructureRepository.findBy_city__id(userEntity.getCity().getId()).orElseThrow(() -> new CustomException("TIG Infrastructure not found"));
        return _userRetributionRepository.findAll()
                .stream()
                .map(u -> UserRetributionDTO.builder()
                        .id(u.getId())
                        .label(u.getRetribution())
                        .quota(u.getQuotaGains())
                        .tigName(tigInfrastructureEntity.getName())
                        .build()
                ).toList();
    }
}
