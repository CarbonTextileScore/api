package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.service.JwtDecoderServiceImpl;
import fr.carbon.textile.score.api.service.user.information.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService _userService;

    private final JwtDecoderServiceImpl _jwtDecoderService;

    public UserController(UserService userService, JwtDecoderServiceImpl jwtDecoderService) {
        _userService = userService;
        _jwtDecoderService = jwtDecoderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUsers() {
        return _userService.getUsers();
    }

    @GetMapping("/identity")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserDTO getUserIdentity() throws CustomException {
        return _userService.getUserIdentity(_jwtDecoderService.recoverUserOfThisRequest());
    }

    @GetMapping("/quota/personal")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserDTO getQuotaPersonal() throws CustomException {
        return _userService.getQuotaPersonal(_jwtDecoderService.recoverUserOfThisRequest());
    }

    @GetMapping("/dashboard")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_USER')")
    public UserDTO getDashboard() throws CustomException {
        System.out.println("getDashboard");
        return _userService.getDashboard(_jwtDecoderService.recoverUserOfThisRequest());
    }
}
