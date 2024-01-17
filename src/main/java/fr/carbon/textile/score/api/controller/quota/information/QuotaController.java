package fr.carbon.textile.score.api.controller.quota.information;

import fr.carbon.textile.score.api.service.quota.information.QuotaService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/quota")
public class QuotaController {
    private QuotaService _quotaService;

    public QuotaController(QuotaService quotaService) {
        _quotaService = quotaService;
    }
}
