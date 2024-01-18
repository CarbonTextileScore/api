package fr.carbon.textile.score.api.repository.training.information;

import fr.carbon.textile.score.api.database.entity.training.information.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity, Integer> {
}
