package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.CityEntity;
import fr.carbon.textile.score.api.dto.quota.information.CityRetributionDTO;
import fr.carbon.textile.score.api.dto.user.information.CityDTO;
import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.repository.user.information.CityRepository;
import fr.carbon.textile.score.api.service.quota.information.CityRetributionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private CityRepository _cityRepository;

    private InvoiceService _invoiceService;

    private CityRetributionService _cityRetributionService;

    public CityServiceImpl(CityRepository cityRepository, InvoiceService invoiceService, CityRetributionService cityRetributionService) {
        super();
        _cityRepository = cityRepository;
        _invoiceService = invoiceService;
        _cityRetributionService = cityRetributionService;
    }

    @Override
    public CityDTO getCityQuota(Integer id) {
        List<InvoiceDTO> invoices = new ArrayList<>();
        CityEntity cityEntity = _cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));

        cityEntity.getUsers().forEach(userEntity -> {
            if(userEntity.getAuthority().getRole().getName().equals("ROLE_USER")) {
                try {
                    invoices.addAll(_invoiceService.getQuarterlyInvoices(userEntity.getId()));
                } catch (CustomException ignored) {}
            }
        });

        Double quota = Double.valueOf(Math.round(invoices.stream().mapToDouble(InvoiceDTO::getQuota).sum() / (450.0 * cityEntity.getUsers().stream().filter(userEntity -> userEntity.getAuthority().getRole().getName().equals("ROLE_USER")).toList().size()) * 100.0));

        return CityDTO.builder()
                .quota(quota)
                .punishments(_cityRetributionService.getAppliedRetributions(quota).stream().map(CityRetributionDTO::getRetribution).toList())
                .punishmentsSoon(_cityRetributionService.getIncomingRetributions(quota).stream().map(CityRetributionDTO::getRetribution).toList())
                .build();
    }
}
