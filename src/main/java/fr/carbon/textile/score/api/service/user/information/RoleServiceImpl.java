package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.repository.user.information.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository _roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        super();
        _roleRepository = roleRepository;
    }
}
