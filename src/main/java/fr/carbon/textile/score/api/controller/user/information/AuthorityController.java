package fr.carbon.textile.score.api.controller.user.information;

import fr.carbon.textile.score.api.dto.user.information.AuthorityDTO;
import fr.carbon.textile.score.api.service.user.information.AuthorityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authority")
public class AuthorityController {
    private AuthorityService _authorityService;

    public AuthorityController(AuthorityService authorityService) {
        super();
        _authorityService = authorityService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthority(@RequestBody @Valid AuthorityDTO authorityDTO) {
        _authorityService.createAuthority(authorityDTO);
    }
}
