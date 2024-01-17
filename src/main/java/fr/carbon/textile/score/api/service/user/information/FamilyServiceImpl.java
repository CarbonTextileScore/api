package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.repository.user.information.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {
    private FamilyRepository _familyRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        super();
        _familyRepository = familyRepository;
    }
}
