package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.service.user.information.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUsers() {
        return _userService.getUsers();
    }

}
