package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.AnimalGender;
import DairyWeb.dairy.DairyEnums.AnimalStatus;
import DairyWeb.dairy.DairyEnums.AnimalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AnimalCreateReqDTO {
    @NotBlank (message = "Please select non empty animal name.")
    private String name;
    @NotNull (message = "Please select animal gender.")
    private AnimalGender gender;
    @NotNull(message = "Please select animal current status.")
    private AnimalStatus status;
    @NotEmpty (message = "Please select animal breed.")
    private String breed;
    @Positive (message = "Please select a valid price of animal purchase.")
    private BigDecimal purchasePrice;
    private LocalDate dateOfBirth;
    private LocalDate dateOfPurchase;

    public AnimalGender getGender() {
        return gender;
    }

    public void setGender(AnimalGender gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void setStatus(AnimalStatus status) {
        this.status = status;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    private String notes;
    @NotNull(message = "Please select either cow or buffalo.")
    private AnimalType type;
}
