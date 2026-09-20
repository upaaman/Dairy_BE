package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.EmployeeSalaryCreateDTO;
import DairyWeb.dairy.DairyEntities.Employee;
import DairyWeb.dairy.DairyEntities.EmployeeSalary;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.EmployeeRepo;
import DairyWeb.dairy.DairyRepository.EmployeeSalaryRepo;
import DairyWeb.dairy.DairySpecifications.EmployeeSalarySpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryService {
    private EmployeeRepo employeeRepo;
    private EmployeeSalaryRepo employeeSalaryRepo;

    public EmployeeSalaryService(EmployeeSalaryRepo employeeSalaryRepo, EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
        this.employeeSalaryRepo=employeeSalaryRepo;
    }
    public EmployeeSalary createEmployeeSalary (EmployeeSalaryCreateDTO req){
        Employee employee= employeeRepo.findById(req.getEmployeeId()).orElseThrow(
                ()-> new BusinessException("Employee with this id not found.")
        );
        EmployeeSalary employeeSalary=new EmployeeSalary();

        employeeSalary.setEffectiveFrom(req.getEffectiveFrom());
        employeeSalary.setEffectiveTo(req.getEffectiveTo());
        employeeSalary.setMonthlySalary(req.getMonthlySalary());
        employeeSalary.setEmployee(employee);

        return employeeSalaryRepo.save(employeeSalary);
    }


    public List<EmployeeSalary> getAllEmployeeSalaries(Long employeeId) {

        Specification<EmployeeSalary> specification =
                (root, query, cb) -> cb.conjunction();

        if (employeeId != null) {
            specification = specification.and(
                    EmployeeSalarySpecifications.hasEmployeeId(employeeId)
            );
        }

        return employeeSalaryRepo.findAll(specification);
    }
}
