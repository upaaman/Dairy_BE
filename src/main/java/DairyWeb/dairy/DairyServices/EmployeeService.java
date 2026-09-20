package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.EmployeeDetailsResDTO;
import DairyWeb.dairy.DairyDTOs.ResponseDTOs.EmployeeSalaryResDTO;
import DairyWeb.dairy.DairyEntities.Employee;
import DairyWeb.dairy.DairyEntities.EmployeeSalary;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.EmployeeRepo;
import DairyWeb.dairy.DairyRepository.EmployeeSalaryRepo;
import DairyWeb.dairy.DairyRepository.SalaryTransactionRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    private EmployeeSalaryRepo employeeSalaryRepo;
    private SalaryTransactionRepo salaryTransactionRepo;

    public EmployeeService(EmployeeRepo employeeRepo, EmployeeSalaryRepo employeeSalaryRepo,SalaryTransactionRepo salaryTransactionRepo){
        this.employeeRepo=employeeRepo;
        this.employeeSalaryRepo=employeeSalaryRepo;
        this.salaryTransactionRepo=salaryTransactionRepo;
    }

    public Employee createEmployee(Employee req){
        return employeeRepo.save(req);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public EmployeeDetailsResDTO getEmployeeDetails(Long id){

        EmployeeDetailsResDTO empDetails=new EmployeeDetailsResDTO();
        Employee emp= employeeRepo.findById(id).orElseThrow(
                ()-> new BusinessException("Employee not found bro.")
        );
        empDetails.setName(emp.getName());
        empDetails.setAddress(emp.getAddress());
        empDetails.setNotes(emp.getNotes());
        empDetails.setContact(emp.getContact());
        empDetails.setDateOfJoining(emp.getDateOfJoining());
        empDetails.setStatus(emp.getStatus());

        List<EmployeeSalary> employeeSalaries=employeeSalaryRepo.findByEmployeeId(id);
        List<EmployeeSalaryResDTO> employeeSalaryResDTOS= employeeSalaries.stream().
        map(sal->{
            EmployeeSalaryResDTO empSalRes=new EmployeeSalaryResDTO();
            empSalRes.setEffectiveFrom(sal.getEffectiveFrom());
            empSalRes.setEffectiveTo(sal.getEffectiveTo());
            empSalRes.setId(sal.getId());
            empSalRes.setMonthlySalary(sal.getMonthlySalary());
            return empSalRes;
        }).toList();

        BigDecimal totalRemainingAmount =
                salaryTransactionRepo.getTotalRemainingAmount(id);

        empDetails.setTotalRemainingAmount(totalRemainingAmount);

        empDetails.setSalaries(employeeSalaryResDTOS);



        return empDetails;
    }
}
