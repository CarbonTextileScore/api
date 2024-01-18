package fr.carbon.textile.score.api.repository.market.information;

import fr.carbon.textile.score.api.database.entity.market.information.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer> {

}
