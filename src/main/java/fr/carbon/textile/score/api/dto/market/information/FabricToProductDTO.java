package fr.carbon.textile.score.api.dto.market.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FabricToProductDTO implements Serializable {
    Integer id;
    FabricDTO fabric;
    ProductDTO product;
    Integer percentage;
}
