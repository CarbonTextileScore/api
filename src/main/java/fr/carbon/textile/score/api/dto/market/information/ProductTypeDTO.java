package fr.carbon.textile.score.api.dto.market.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTypeDTO implements Serializable {
    @PositiveOrZero(message = "Product Type id must be positive or zero")
    Integer id;
    @NotBlank(message = "Product Type name must not be blank")
    String name;
}
