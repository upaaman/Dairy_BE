package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepo extends JpaRepository<Animal,Long> {
    List<Animal> findByActiveTrue();

    List<Animal> findByActiveFalse();
}
