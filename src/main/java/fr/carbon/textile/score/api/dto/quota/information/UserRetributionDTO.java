package fr.carbon.textile.score.api.dto.quota.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRetributionDTO implements Serializable {
    Integer id;
    Integer quota;
    String label;
}
