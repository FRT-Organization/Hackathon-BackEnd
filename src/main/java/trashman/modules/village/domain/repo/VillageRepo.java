package trashman.modules.village.domain.repo;

import trashman.modules.village.domain.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepo extends JpaRepository<Village, Long> {
}
