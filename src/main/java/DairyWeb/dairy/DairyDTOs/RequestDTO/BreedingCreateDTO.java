package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.BreedingMethod;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BreedingCreateDTO {
    @NotNull(message = "Please provide  animal.")
    private Long animal;
    @NotNull(message = "Please provide breeding date.")
    private LocalDate breedingDate;
    @NotNull(message = "Please provide method.")
    private BreedingMethod method;
    @NotNull(message = "Please provide expected date.")
    private LocalDate expectedCalvingDate;
    private String notes;

    public Long getAnimal() {
        return animal;
    }

    public LocalDate getBreedingDate() {
        return breedingDate;
    }

    public BreedingMethod getMethod() {
        return method;
    }

    public LocalDate getExpectedCalvingDate() {
        return expectedCalvingDate;
    }

    public String getNotes() {
        return notes;
    }

}
