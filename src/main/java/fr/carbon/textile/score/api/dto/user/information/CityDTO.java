package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDTO implements Serializable {
    Integer id;
    String name;
    CountryDTO country;

    Double quota;
    List<String> punishments;
    List<String> punishmentsSoon;
}
