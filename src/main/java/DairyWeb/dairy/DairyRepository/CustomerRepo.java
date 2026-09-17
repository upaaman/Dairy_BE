package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
