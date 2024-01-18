package fr.carbon.textile.score.api.controller.training.information;

import fr.carbon.textile.score.api.dto.training.information.TrainingDTO;
import fr.carbon.textile.score.api.repository.training.information.TrainingRepository;
import fr.carbon.textile.score.api.service.quota.information.CityRetributionService;
import fr.carbon.textile.score.api.service.training.information.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/training/videos")
public class TrainingController {
    private TrainingService _trainingService;

    public TrainingController(TrainingService trainingService) {
        _trainingService = trainingService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<TrainingDTO> getAll() {
        return _trainingService.getAll();
    }
}
