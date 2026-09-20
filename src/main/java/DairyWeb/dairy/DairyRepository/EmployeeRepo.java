package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
