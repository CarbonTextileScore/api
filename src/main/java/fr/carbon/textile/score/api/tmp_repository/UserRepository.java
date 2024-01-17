package fr.carbon.textile.score.api.tmp_repository;

import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(
            "SELECT user FROM User user WHERE upper(user._authority._username) = upper(:username)"
    )
    Optional<UserEntity> queryByAuthorityUsername(@NotBlank @Param("username") String username);
}
