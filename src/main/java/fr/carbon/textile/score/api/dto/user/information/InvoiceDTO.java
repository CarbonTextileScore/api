package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.carbon.textile.score.api.dto.market.information.ProductTypeDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceDTO {
    @PositiveOrZero(message = "Invoice id must be positive or zero")
    Integer id;
    @NotNull(message = "Invoice date must not be null")
    String date;
    @NotNull(message = "Invoice quota must not be null")
    Integer quota;
    Double productPrice;
    @NotNull(message = "Invoice user must not be null")
    UserDTO user;
    @NotNull(message = "Invoice product type must not be null")
    ProductTypeDTO productType;
    @Pattern(regexp = "^(VENTE |ACHAT )\\s.*$", message = "Product qualifier name must start with 'VENTE ' or 'ACHAT '")
    String productQualifier;

    String label;
}
