package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.repository.user.information.UserToFamilyRepository;
import org.springframework.stereotype.Service;

@Service
public class UserToFamilyServiceImpl implements UserToFamilyService {
    private UserToFamilyRepository _userToFamilyRepository;

    public UserToFamilyServiceImpl(UserToFamilyRepository userToFamilyRepository) {
        super();
        _userToFamilyRepository = userToFamilyRepository;
    }
}
