package fr.carbon.textile.score.api.controller.training.information;

import fr.carbon.textile.score.api.service.quota.information.CityRetributionService;
import fr.carbon.textile.score.api.service.training.information.VideoCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video-category")
public class VideoCategoryController {
    private VideoCategoryService _videoCategoryService;

    public VideoCategoryController(VideoCategoryService videoCategoryService) {
        videoCategoryService = videoCategoryService;
    }
}
