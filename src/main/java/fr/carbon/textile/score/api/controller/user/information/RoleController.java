package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.service.user.information.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService _roleService;

    public RoleController(RoleService roleService) {
        super();
        _roleService = roleService;
    }
}
