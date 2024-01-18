package fr.carbon.textile.score.api.repository.market.information;

import fr.carbon.textile.score.api.database.entity.market.information.ProductEntity;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query(
            "SELECT product FROM Product product LEFT JOIN FETCH product._fabrics WHERE product._id = :id"
    )
    Optional<ProductEntity> queryByIdWithFabrics(
            @PositiveOrZero @Param("id") Integer id
    );
}
