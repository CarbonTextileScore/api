package fr.carbon.textile.score.api.repository.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.InvoiceEntity;
import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.dto.user.information.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {

    @Query(
            "SELECT invoice FROM Invoice invoice " +
            "WHERE invoice._date BETWEEN :beginTimestamp AND :endTimestamp " +
            "AND invoice._user._id = :userId"
    )
    List<InvoiceEntity> queryAllByUserAndBetweenTimestamp(
            @NonNull @Param("beginTimestamp") Timestamp beginTimestamp,
            @NonNull @Param("endTimestamp") Timestamp endTimestamp,
            @NonNull @Param("userId") Integer userId
    );
}
