package fr.carbon.textile.score.api.controller.training.information;

import fr.carbon.textile.score.api.dto.training.information.VideoCategoryDTO;
import fr.carbon.textile.score.api.service.quota.information.CityRetributionService;
import fr.carbon.textile.score.api.service.training.information.VideoCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/training/categories")
public class VideoCategoryController {
    private VideoCategoryService _videoCategoryService;

    public VideoCategoryController(VideoCategoryService videoCategoryService) {
        _videoCategoryService = videoCategoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<VideoCategoryDTO> getAll() {
        return _videoCategoryService.getAll();
    }
}
