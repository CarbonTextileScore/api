package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.repository.user.information.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository _countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        super();
        _countryRepository = countryRepository;
    }
}
