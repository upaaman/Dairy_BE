package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal,Long> {
}
