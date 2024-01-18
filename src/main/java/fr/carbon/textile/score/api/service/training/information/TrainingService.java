package fr.carbon.textile.score.api.service.training.information;

import fr.carbon.textile.score.api.dto.training.information.TrainingDTO;

import java.util.List;

public interface TrainingService {
    List<TrainingDTO> getAll();
}
