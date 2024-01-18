package fr.carbon.textile.score.api.repository.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.RoleEntity;
import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserDTO getUserIdentity(Integer id);
    @Query(
            "SELECT user FROM User user WHERE upper(user._authority._username) = upper(:username)"
    )
    Optional<UserEntity> queryByAuthorityUsername(@NotBlank @Param("username") String username);

    @Query(
            "SELECT user FROM User user LEFT JOIN FETCH user._invoices WHERE user._authority._role._name = :role"
    )
    List<UserEntity> queryAllWithInvoicesByAuthorityRole(@NonNull @Param("role") String role);
}
