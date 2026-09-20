package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.EmployeeDetailsResDTO;
import DairyWeb.dairy.DairyEntities.Employee;
import DairyWeb.dairy.DairyServices.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping("create")
    public Employee createEmployee(@Valid @RequestBody Employee  emp){
        return employeeService.createEmployee(emp);
    }

    @GetMapping("getAll")
    public List<Employee> createEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("details/{id}")
    public EmployeeDetailsResDTO getEmployeeDetails(@PathVariable Long id){
        return employeeService.getEmployeeDetails(id);
    }

}
