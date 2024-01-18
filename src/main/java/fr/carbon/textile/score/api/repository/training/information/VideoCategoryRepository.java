package fr.carbon.textile.score.api.repository.training.information;

import fr.carbon.textile.score.api.database.entity.training.information.VideoCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoCategoryRepository extends JpaRepository<VideoCategoryEntity, Integer> {
}
