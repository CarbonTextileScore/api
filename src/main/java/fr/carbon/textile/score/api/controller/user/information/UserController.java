package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.service.JwtDecoderServiceImpl;
import fr.carbon.textile.score.api.service.user.information.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService _userService;

    private JwtDecoderServiceImpl _jwtDecoderService;

    public UserController(UserService userService, JwtDecoderServiceImpl jwtDecoderService) {
        _userService = userService;
        _jwtDecoderService = jwtDecoderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUsers() {
        return _userService.getUsers();
    }

    @GetMapping("/{id}/identity")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserDTO getUserIdentity(@PathVariable("id") Integer id) {
        return _userService.getUserIdentity(id, _jwtDecoderService.recoverUserOfThisRequest());
    }
}
