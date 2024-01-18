package fr.carbon.textile.score.api.dto.training.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.carbon.textile.score.api.database.entity.training.information.VideoCategoryEntity;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainingDTO implements Serializable {
    Integer id;
    String name;
    String video;
    Integer stars;
    String userFullName;
    byte[] userPicture;
    VideoCategoryDTO videoCategory;

}
