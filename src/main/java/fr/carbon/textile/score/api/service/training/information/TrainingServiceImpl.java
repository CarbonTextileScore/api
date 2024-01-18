package fr.carbon.textile.score.api.service.training.information;

import fr.carbon.textile.score.api.dto.training.information.TrainingDTO;
import fr.carbon.textile.score.api.repository.training.information.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {
    private TrainingRepository _trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        super();
        _trainingRepository = trainingRepository;
    }

    @Override
    public List<TrainingDTO> getAll() {
        return _trainingRepository.findAll().stream().map(trainingEntity -> TrainingDTO.builder()
                .id(trainingEntity.getId())
                .name(trainingEntity.getName())
                .video(trainingEntity.getVideo())
                .categoryId(trainingEntity.getVideoCategory().getId())
                .score(trainingEntity.getStars())
                .userFullName(trainingEntity.getUserFullName())
                .build()).toList();
    }
}
