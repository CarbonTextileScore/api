package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.service.JwtDecoderService;
import fr.carbon.textile.score.api.service.user.information.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceService _invoiceService;
    private final JwtDecoderService _jwtDecoderService;

    public InvoiceController(InvoiceService invoiceService, JwtDecoderService jwtDecoderService) {
        super();
        _invoiceService = invoiceService;
        _jwtDecoderService = jwtDecoderService;
    }

    @GetMapping("/quarterly")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_CITY')")
    public List<InvoiceDTO> getQuarterlyInvoices() throws CustomException {
        return _invoiceService.getQuarterlyInvoices(_jwtDecoderService.recoverUserOfThisRequest().getId());
    }
}
