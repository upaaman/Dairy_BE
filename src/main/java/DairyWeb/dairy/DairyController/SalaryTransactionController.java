package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.SalaryTransactionCreateDTO;
import DairyWeb.dairy.DairyEntities.SalaryTransaction;
import DairyWeb.dairy.DairyEnums.SalaryTransactionType;
import DairyWeb.dairy.DairyServices.SalaryTransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/salaryTransaction")
public class SalaryTransactionController {
    private SalaryTransactionService salaryTransactionService;
    public SalaryTransactionController( SalaryTransactionService salaryTransactionService ){
        this.salaryTransactionService=salaryTransactionService;
    }

@PostMapping("/create")
    public SalaryTransaction createSalaryTransaction(
            @Valid @RequestBody SalaryTransactionCreateDTO req){
    return salaryTransactionService.createSalaryTransaction(req);
}
    @GetMapping("/getAll")
    public List<SalaryTransaction> getAllLedgers(
            @RequestParam(required = false) Long employeeId,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(required = false) String salaryMonth,
            @RequestParam(required = false) SalaryTransactionType type
    ){
        return salaryTransactionService.getAllSalaryTransactions(
                employeeId,
                startDate,
                endDate,
                salaryMonth,
                type
        );
    }
}
