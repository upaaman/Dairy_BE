package DairyWeb.dairy.DairyDTOs.RequestDTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class VaccineCreateDTO {

    private String notes;

    public String getNotes() {
        return notes;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    @NotNull(message = "Please select animal")
    private Long animalId;
    @NotNull(message = "Please enter vaccine name")
    private String vaccineName;
    @NotNull(message = "Please enter vaccine date")
    private LocalDate vaccineDate;
}
