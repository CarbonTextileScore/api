package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.service.user.information.UserToFamilyService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user-to-family")
public class UserToFamilyController {
    private UserToFamilyService _userToFamilyService;

    public UserToFamilyController(UserToFamilyService userToFamilyService) {
        _userToFamilyService = userToFamilyService;
    }
}
