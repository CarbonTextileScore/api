package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.carbon.textile.score.api.dto.market.information.ProductTypeDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvoiceDTO {
    Integer id;
    Date date;
    Integer quota;
    Double productPrice;
    UserDTO user;
    ProductTypeDTO productType;
}
