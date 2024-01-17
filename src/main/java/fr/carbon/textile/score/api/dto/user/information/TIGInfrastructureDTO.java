package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TIGInfrastructureDTO {
    Integer id;
    String name;
    CityDTO cityDTO;
}
