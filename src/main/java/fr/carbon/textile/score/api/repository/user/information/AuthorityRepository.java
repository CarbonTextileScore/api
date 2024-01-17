package fr.carbon.textile.score.api.repository.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.AuthorityEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
    @Query(
            "SELECT authority FROM Authority authority WHERE authority._username = :username"
    )
    Optional<AuthorityEntity> queryByUsername(
            @NotBlank @Param(value = "username") String username
    );
}
