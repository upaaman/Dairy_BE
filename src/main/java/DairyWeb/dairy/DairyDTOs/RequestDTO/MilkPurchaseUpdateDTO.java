package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MilkPurchaseUpdateDTO {
    @NotNull(message = "Please select purchase date.")
    private LocalDate purchaseDate;

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public MilkShifts getShift() {
        return shift;
    }


    public AnimalType getAnimalType() {
        return animalType;
    }

    @NotNull(message = "Please select quantity.")
    @Positive(message = "Please select a valud quantity value.")
    private BigDecimal quantity;
    @NotNull(message = "Please select rate.")
    @Positive(message = "Please select a valud rate value.")
    private BigDecimal rate;
    @NotNull(message = "Please select sellerId.")
    private Long sellerId;
    @NotNull(message = "Please select shift.")
    private MilkShifts shift;
    @NotNull(message = "Please select animal type.")
    private AnimalType animalType;
}
