package fr.carbon.textile.score.api.repository.user.information;

import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserRepositoryImpl {
    private EntityManager _entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    public UserDTO getUserIdentity(Integer id) {
        String req = "SELECT DISTINCT u._name, u._lastname, u._birthdate, " +
                "    CASE WHEN u._birthdate = ( " +
                "        SELECT MIN(u2._birthdate) FROM User u2 " +
                "        WHERE u2._family._id = u._family._id " +
                "    ) THEN ( " +
                "        SELECT COUNT(*) FROM User u2 " +
                "        WHERE u2._family._id = u._family._id " +
                "        AND u2._id <> u._id " +
                "        AND CAST(date_part('year', age(u2._birthdate)) as integer)  < 12 " +
                ") END AS _numberOfChildren " +
                "FROM User u " +
                "WHERE u._id = :id";

        TypedQuery<Tuple> query = _entityManager.createQuery(req, Tuple.class);
        query.setParameter("id", id);

        Tuple result = query.getSingleResult();

        return UserDTO.builder()
                .name((String) result.get(0))
                .lastname((String) result.get(1))
                .birthdate((Date) result.get(2))
                .numberOfChildren(((Long) result.get(3)).intValue())
                .build();
    }
}
