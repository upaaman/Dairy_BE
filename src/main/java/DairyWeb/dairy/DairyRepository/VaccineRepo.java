package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepo extends JpaRepository<Vaccine,Long> {
}
