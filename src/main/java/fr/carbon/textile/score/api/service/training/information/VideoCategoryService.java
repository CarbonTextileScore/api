package fr.carbon.textile.score.api.service.training.information;

import fr.carbon.textile.score.api.dto.training.information.VideoCategoryDTO;

import java.util.List;

public interface VideoCategoryService {
    List<VideoCategoryDTO> getAll();
}
