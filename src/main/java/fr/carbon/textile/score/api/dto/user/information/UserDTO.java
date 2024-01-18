package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.carbon.textile.score.api.dto.quota.information.QuotaDTO;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {
    Integer id;
    String name;
    String lastname;
    String gender;
    Date birthdate;
    byte[] picture;
    QuotaDTO availableQuota;
    CityDTO city;
    FamilyDTO family;
    Integer numberOfChildren;
}
