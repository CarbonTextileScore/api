package fr.carbon.textile.score.api.repository.quota.information;

import fr.carbon.textile.score.api.database.entity.quota.information.CityRetributionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRetributionRepository extends JpaRepository<CityRetributionEntity, Integer> {
    List<CityRetributionEntity> findBy_triggerPercentageGreaterThan(int _triggerPercentage);
    List<CityRetributionEntity> findBy_triggerPercentageLessThan(int _triggerPercentage);
    List<CityRetributionEntity> findBy_triggerPercentageLessThanEqual(int _triggerPercentage);
}
