package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.repository.user.information.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    private CityRepository _cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        super();
        _cityRepository = cityRepository;
    }
}
