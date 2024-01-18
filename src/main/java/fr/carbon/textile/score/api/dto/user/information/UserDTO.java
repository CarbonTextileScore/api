package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.carbon.textile.score.api.dto.quota.information.QuotaDTO;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO implements Serializable {
    @PositiveOrZero(message = "User id must be positive or zero")
    Integer id;
    @NotBlank(message = "User name must not be blank")
    String name;
    @NotBlank(message = "User lastname must not be blank")
    String lastname;
    @NotNull(message = "User birthdate must not be null")
    String birthdate;
    @NotEmpty(message = "User picture must not be empty")
    byte[] picture;
    @NotBlank(message = "User gender must not be blank")
    String gender;
    //TODO for now it is nullable
    @Null
    QuotaDTO quota;
    @NotNull(message = "User city must not be null")
    CityDTO city;
    FamilyDTO family;

    Integer numberOfChildren;
    @Null
    List<InvoiceDTO> invoices;
    Double personalQuota;
    Double familyQuota;
    List<UserDTO> familyMembers;
    Integer age;
}