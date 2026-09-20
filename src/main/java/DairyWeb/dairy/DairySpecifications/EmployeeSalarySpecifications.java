package DairyWeb.dairy.DairySpecifications;

import DairyWeb.dairy.DairyEntities.EmployeeSalary;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSalarySpecifications {

    public static Specification<EmployeeSalary> hasEmployeeId(Long employeeId) {
        return (root, query, cb) ->
                cb.equal(root.get("employee").get("id"), employeeId);
    }
}