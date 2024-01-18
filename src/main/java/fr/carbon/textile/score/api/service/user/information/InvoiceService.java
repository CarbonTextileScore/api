package fr.carbon.textile.score.api.service.user.information;

import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDTO> getQuarterlyInvoices(
            @Valid @PositiveOrZero(message = "Id must be positive or zero") Integer id
    ) throws CustomException;
}
