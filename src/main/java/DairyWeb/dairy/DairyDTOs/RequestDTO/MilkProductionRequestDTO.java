package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.MilkShifts;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MilkProductionRequestDTO {
    @NotNull(message = "Please enter quantity.")
    @Positive(message = "Please enter a valid positive quantity.")
    private BigDecimal quantity;
    @NotNull(message = "Please select shift.")
    private MilkShifts shift;
    @NotNull(message = "Please select animal.")
    private Long animalId;
    @NotNull
    private LocalDate productionDate;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public MilkShifts getShift() {
        return shift;
    }

    public void setShift(MilkShifts shift) {
        this.shift = shift;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public MilkProductionRequestDTO(BigDecimal quantity, MilkShifts shift, Long animalId, LocalDate productionDate) {
        this.quantity = quantity;
        this.shift = shift;
        this.animalId = animalId;
        this.productionDate = productionDate;
    }
}
