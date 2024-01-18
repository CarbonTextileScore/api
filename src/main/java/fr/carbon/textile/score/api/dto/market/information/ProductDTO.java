package fr.carbon.textile.score.api.dto.market.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO implements Serializable {
    Integer id;
    String name;
    Double area;
    Double price;
    Boolean isSecondHand;
    Boolean isSold;
    ProductTypeDTO productType;
    FabricToProductDTO fabric;
    Double mass;
}
