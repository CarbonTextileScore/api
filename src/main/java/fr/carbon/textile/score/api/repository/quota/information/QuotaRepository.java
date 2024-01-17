package fr.carbon.textile.score.api.repository.quota.information;

import fr.carbon.textile.score.api.database.entity.quota.information.QuotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotaRepository extends JpaRepository<QuotaEntity, Integer> {
}
