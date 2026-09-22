package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.ExpenseCreateReqDTO;
import DairyWeb.dairy.DairyEntities.Expense;
import DairyWeb.dairy.DairyServices.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
        this.expenseService=expenseService;
    }
    @PostMapping("/create")
    public Expense createExpense(
            @Valid @RequestBody ExpenseCreateReqDTO request
    ){
        return expenseService.createExpense(request);
    }

    @GetMapping("/getAll")
    public List<Expense> getAllExpeses(){
        return expenseService.getAllExpeses();
    }
}
