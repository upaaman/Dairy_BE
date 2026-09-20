package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeSalaryRepo extends JpaRepository<EmployeeSalary,Long> , JpaSpecificationExecutor<EmployeeSalary> {
    List<EmployeeSalary> findByEmployeeId(Long id);
}
