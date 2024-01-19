package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.InvoiceEntity;
import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.mapper.DTOEntitiesMapperWrapper;
import fr.carbon.textile.score.api.mapper.user.information.InvoiceMapper;
import fr.carbon.textile.score.api.repository.user.information.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository _invoiceRepository;
    private final static int QUARTER_LEN_IN_MONTH = 2;
    private final static int QUARTER_SPARE = 1;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        super();
        _invoiceRepository = invoiceRepository;
    }

    private static LocalDate getLastDayOfGivenFirstDayQuarter(LocalDate firstDayOfQuarter) {
        return firstDayOfQuarter.plusMonths(QUARTER_LEN_IN_MONTH).with(TemporalAdjusters.lastDayOfMonth());
    }

    private static LocalDate getFirstDayOfCurrentDate(LocalDate current) {
        return current.with(TemporalAdjusters.firstDayOfYear()).with(TemporalAdjusters.firstDayOfMonth());
    }

    private static LocalDate getFirstDayOfQuarter(LocalDate last) {
        return last.plusMonths(QUARTER_SPARE).with(TemporalAdjusters.firstDayOfMonth());
    }

    private LocalDate getFirstDayOfCurrentQuarter(LocalDate current) {
        LocalDate first = getFirstDayOfCurrentDate(current);
        LocalDate last = getLastDayOfGivenFirstDayQuarter(first);
        while (current.isAfter(last)) {
            first = getFirstDayOfQuarter(last);
            last = getLastDayOfGivenFirstDayQuarter(first);
        }
        return first;
    }

    @Override
    public List<InvoiceDTO> getQuarterlyInvoices(Integer id) {
        LocalDate firstDayOfQuarter = getFirstDayOfCurrentQuarter(LocalDate.now().plusYears(30));
        LocalDate lastDayOfQuarter = getLastDayOfGivenFirstDayQuarter(firstDayOfQuarter);

        List<InvoiceEntity> entities = _invoiceRepository.queryAllByUserAndBetweenTimestamp(
                Timestamp.valueOf(firstDayOfQuarter.atStartOfDay()),
                Timestamp.valueOf(lastDayOfQuarter.atStartOfDay()),
                id
        );
        List<InvoiceDTO> invoiceDTOs = new ArrayList<>();
        for (InvoiceEntity entity : entities) {
            String productQualifier = "VENTE ";
            if (entity.getProductPrice() < 0) {
                productQualifier = "ACHAT ";
            }
            invoiceDTOs.add(InvoiceDTO.builder()
                    .quota(entity.getQuota())
                    .date(new SimpleDateFormat("dd/MM/yyyy").format(entity.getDate()))
                    .productPrice(Math.round(entity.getProductPrice() * 100.0) / 100.0)
                    .productQualifier(productQualifier + entity.getProductType().getName())
                    .build());
        }
        return invoiceDTOs;
    }
}
