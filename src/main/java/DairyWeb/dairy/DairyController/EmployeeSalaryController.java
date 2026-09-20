package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.EmployeeSalaryCreateDTO;
import DairyWeb.dairy.DairyEntities.EmployeeSalary;
import DairyWeb.dairy.DairyServices.EmployeeSalaryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salary")
public class EmployeeSalaryController {
    private EmployeeSalaryService employeeSalaryService;
    public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService){
        this.employeeSalaryService=employeeSalaryService;
    }

    @PostMapping("/create")
    public EmployeeSalary createEmployeeSalary(
            @Valid @RequestBody EmployeeSalaryCreateDTO request
            ){
        return employeeSalaryService.createEmployeeSalary(request);
    }

    @GetMapping("/getAll")
    public List<EmployeeSalary> createEmployeeSalary(
            @RequestParam(required = false) Long employeeId
    ){
        return employeeSalaryService.getAllEmployeeSalaries(employeeId);
    }
}
