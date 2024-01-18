package fr.carbon.textile.score.api.controller.training.information;

import fr.carbon.textile.score.api.repository.training.information.TrainingRepository;
import fr.carbon.textile.score.api.service.quota.information.CityRetributionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training")
public class TrainingController {
    private TrainingRepository _trainingRepository;

    public TrainingController(TrainingRepository trainingRepository) {
        trainingRepository = trainingRepository;
    }
}
