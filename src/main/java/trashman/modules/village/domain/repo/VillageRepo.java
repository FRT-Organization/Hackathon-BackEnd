package trashman.modules.village.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trashman.modules.village.domain.entity.Village;

@Repository
public interface VillageRepo extends JpaRepository<Village, Long> {
}
