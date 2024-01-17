package fr.carbon.textile.score.api.dto.market.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.carbon.textile.score.api.database.entity.market.information.FabricsToProductEntity;
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
    boolean isSecondHand;
    FabricsToProductEntity fabric;
}
