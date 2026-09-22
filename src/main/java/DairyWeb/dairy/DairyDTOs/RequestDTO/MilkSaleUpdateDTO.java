package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEntities.Customer;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MilkSaleUpdateDTO {
    @NotNull(message = "Please provide sale date")
    private LocalDate saleDate;
    @NotNull(message = "Please provide sale quantity")
    private BigDecimal quantity;
    @NotNull(message = "Please provide sale rate")
    private BigDecimal rate;
    @NotNull(message = "Please provide customer")
    private Long customerId;

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MilkShifts getShift() {
        return shift;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    @NotNull(message = "Please provide sale amount")
    private BigDecimal amount;
    @NotNull(message = "Please provide sale shift")
    private MilkShifts shift;
    @NotNull(message = "Please provide animal type")
    private AnimalType animalType ;
}
