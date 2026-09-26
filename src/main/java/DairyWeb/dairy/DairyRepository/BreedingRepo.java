package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Breeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BreedingRepo extends JpaRepository<Breeding,Long> , JpaSpecificationExecutor<Breeding> {
    List<Breeding> findByAnimalIdAndProducedAnimalIsNotNull(Long id);

    Optional<Breeding> findFirstByProducedAnimalId(Long id);
}
