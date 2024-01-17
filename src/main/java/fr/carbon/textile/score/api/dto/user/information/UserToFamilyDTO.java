package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserToFamilyDTO {
    Integer id;
    UserDTO user;
    FamilyDTO family;
}
