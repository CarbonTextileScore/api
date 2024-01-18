package fr.carbon.textile.score.api.service;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import fr.carbon.textile.score.api.exception.CustomException;

public interface JwtDecoderService {
    UserDTO recoverUserOfThisRequest() throws CustomException;
}
