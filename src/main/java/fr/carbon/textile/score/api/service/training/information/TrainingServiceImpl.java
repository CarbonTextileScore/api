package fr.carbon.textile.score.api.service.training.information;

import fr.carbon.textile.score.api.repository.training.information.TrainingRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService {
    private TrainingRepository _trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        super();
        _trainingRepository = trainingRepository;
    }
}
