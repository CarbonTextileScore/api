package fr.carbon.textile.score.api.service;

import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import org.springframework.stereotype.Service;

public interface JwtDecoderService {
    UserEntity recoverUserOfThisRequest();
}
