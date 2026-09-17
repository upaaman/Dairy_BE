
package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MilkSaleRequstDTO {

    private LocalDate saleDate;
    private BigDecimal quantity;
    private BigDecimal rate;
    private Long customerId;

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public MilkShifts getShift() {
        return shift;
    }

    public void setShift(MilkShifts shift) {
        this.shift = shift;
    }

    private AnimalType animalType;
    private MilkShifts shift;
}