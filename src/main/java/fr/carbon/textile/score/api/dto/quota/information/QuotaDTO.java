package fr.carbon.textile.score.api.dto.quota.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuotaDTO {
    Integer id;
    RetributionRequirementDTO characteristic;
    Integer maxQuotaQuaterly;
}
