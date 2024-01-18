package fr.carbon.textile.score.api.dto.training.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoCategoryDTO implements Serializable {
    Integer id;
    String name;
}
