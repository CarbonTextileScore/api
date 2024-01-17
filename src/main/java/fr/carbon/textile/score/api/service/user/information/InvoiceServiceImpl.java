package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.repository.user.information.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository _invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        super();
        _invoiceRepository = invoiceRepository;
    }
}
