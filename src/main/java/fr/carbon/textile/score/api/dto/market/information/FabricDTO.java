package fr.carbon.textile.score.api.dto.market.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.carbon.textile.score.api.database.entity.market.information.FabricAnimalOriginEntity;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FabricDTO implements Serializable {
    Integer id;
    String name;
    double waterConsumptionCubicCentimeterPerGram;
    double kilogramCO2EquivalentPerSquareMetre;
    FabricAnimalOriginEntity fabricAnimalOrigin;
}
