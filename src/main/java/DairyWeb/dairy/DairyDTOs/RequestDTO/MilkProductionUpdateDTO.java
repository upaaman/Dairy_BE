package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.MilkShifts;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MilkProductionUpdateDTO {
    @NotNull(message = "Please enter quantity.")
    @Positive(message = "Please enter a valid positive quantity.")
    private BigDecimal quantity;
    @NotNull(message = "Please select shift.")
    private MilkShifts shift;
    @NotNull(message = "Please select animal.")
    private Long animalId;
    @NotNull(message = "Please select production date.")
    private LocalDate productionDate;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public MilkShifts getShift() {
        return shift;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }
}
