package fr.carbon.textile.score.api.controller.quota.information;

import fr.carbon.textile.score.api.dto.quota.information.UserRetributionDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.service.JwtDecoderServiceImpl;
import fr.carbon.textile.score.api.service.quota.information.UserRetributionService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/retribution")
public class UserRetributionController {
    private UserRetributionService _userRetributionService;

    private final JwtDecoderServiceImpl _jwtDecoderService;

    public UserRetributionController(UserRetributionService userRetributionService, JwtDecoderServiceImpl jwtDecoderService) {
        _userRetributionService = userRetributionService;
        _jwtDecoderService = jwtDecoderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<UserRetributionDTO> getUserRetributions() throws CustomException {
        return _userRetributionService.getUserRetributions(_jwtDecoderService.recoverUserOfThisRequest());
    }
}
