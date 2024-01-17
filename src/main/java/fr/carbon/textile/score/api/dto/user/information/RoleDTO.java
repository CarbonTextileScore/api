package fr.carbon.textile.score.api.dto.user.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO {
    @Null(message = "Role id mustn't be set by user")
    Integer id;
    @NotBlank(message = "Role name is mandatory")
    @Pattern(regexp = "^ROLE_*$", message = "Role name must start with ROLE_")
    String name;
}
