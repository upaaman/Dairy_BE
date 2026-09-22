package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.ExpenseType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ExpenseCreateReqDTO {
    @NotEmpty(message = "Please provide notes for this expense.")
    private String notes;
    @NotNull(message = "Please provide valid expense date.")
    private LocalDate expenseDate;
    @Positive(message = "Please provide valid positive amount for this expense.")
    @NotNull (message = "Please provide amount for this expense.")
    private Long amount;

    public String getNotes() {
        return notes;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public Long getAmount() {
        return amount;
    }

    public ExpenseType getType() {
        return type;
    }

    public Long getAnimalId() {
        return animalId;
    }

    @NotNull(message = "Please provide valid type for this expense.")
    private ExpenseType type;
    private Long animalId;
}
