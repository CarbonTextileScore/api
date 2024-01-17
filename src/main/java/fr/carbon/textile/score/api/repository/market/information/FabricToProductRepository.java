package fr.carbon.textile.score.api.repository.market.information;

import fr.carbon.textile.score.api.database.entity.market.information.FabricsToProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricToProductRepository extends JpaRepository<FabricsToProductEntity, Integer> {

}
