package fr.carbon.textile.score.api.repository.user.information;

import fr.carbon.textile.score.api.database.entity.user.information.TIGInfrastructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TIGInfrastructureRepository extends JpaRepository<TIGInfrastructureEntity, Integer> {
}